package med.voll.api.domain.appointment;

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

        var patient = patientRepository.findById(data.idPatient()).get();
        var doctor = doctorRepository.findById(data.idDoctor()).get();
        var appointment = new Appointment(null, doctor, patient, data.date());
        repository.save(appointment);
    }
}
