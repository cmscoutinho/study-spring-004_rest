package med.voll.api.domain.appointment;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.validations.AppointmentBookingValidator;
import med.voll.api.domain.appointment.validations.AppointmentCancellationValidator;
import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.DoctorRepository;
import med.voll.api.domain.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentBooking {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private List<AppointmentBookingValidator> bookingValidators;
    @Autowired
    private List<AppointmentCancellationValidator>  cancellationValidators;

    public AppointmentDetailmentData book(AppointmentBookingData data) {
        if(!patientRepository.existsById(data.idPatient())) {
            throw new ValidationException("ID of given patient does not exist!");
        }

        if(data.idDoctor() != null && !doctorRepository.existsById(data.idDoctor())) {
            throw new ValidationException("ID of given doctor does not exist!");
        }

        bookingValidators.forEach(v -> v.validate(data));

        var patient = patientRepository.getReferenceById(data.idPatient());
        var doctor = chooseDoctor(data);

        if (doctor == null) {
            throw new ValidationException("No available doctors for this date.");
        }
        var appointment = new Appointment(null, doctor, patient, data.date(), null);
        appointmentRepository.save(appointment);

        return new AppointmentDetailmentData(appointment);
    }

    private Doctor chooseDoctor(AppointmentBookingData data) {
        if (data.idDoctor() != null)
            return doctorRepository.getReferenceById(data.idDoctor());

        if (data.speciality() == null)
            throw new ValidationException("Speciality needed when no doctor is chosen!");

        return doctorRepository.chooseRandomDoctorAvailableInDate(data.speciality(), data.date());
    }

    public void cancel(AppointmentCancellationData data) {
        if (!appointmentRepository.existsById(data.idAppointment())) {
            throw new ValidationException("The given appointment id doesn't exist!");
        }

        cancellationValidators.forEach(v -> v.validate(data));

        var appointment = appointmentRepository.getReferenceById(data.idAppointment());
        appointment.cancel(data.reason());
    } 
}
