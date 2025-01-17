package med.voll.api.domain.appointment;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.DoctorRepository;
import med.voll.api.domain.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentBooking {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public void book(AppointmentBookingData data) {
        if(!patientRepository.existsById(data.idPatient())) {
            throw new ValidationException("ID of given patient does not exist!");
        }

        if(data.idDoctor() != null && !doctorRepository.existsById(data.idDoctor())) {
            throw new ValidationException("ID of given doctor does not exist!");
        }

        var patient = patientRepository.getReferenceById(data.idPatient());
        var doctor = chooseDoctor(data);
        var appointment = new Appointment(null, doctor, patient, data.date());
        repository.save(appointment);
    }

    private Doctor chooseDoctor(AppointmentBookingData data) {
        if (data.idDoctor() != null)
            return doctorRepository.getReferenceById(data.idDoctor());

        if (data.speciality() == null)
            throw new ValidationException("Speciality needed when no doctor is chosen!");

        return doctorRepository.chooseRandomDoctorAvailableInDate(data.speciality(), data.date());
    }
}
