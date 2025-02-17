package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentBookingData;
import med.voll.api.domain.doctor.DoctorRepository;

public class ActiveDoctorValidator implements AppointmentBookingValidator {

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
