package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentBookingData;
import med.voll.api.domain.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveDoctorValidator implements AppointmentBookingValidator {

    @Autowired
    private DoctorRepository repository;

    public void validate(AppointmentBookingData data) {
        var doctor = data.idDoctor();

        if (doctor == null) {
            return;
        }

        boolean isDoctorActive = repository.findActiveById(doctor);
        if (!isDoctorActive) {
            throw new ValidationException("The given doctor is not active!");
        }
    }
}
