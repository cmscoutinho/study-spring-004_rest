package med.voll.api.domain.appointment.validations.booking;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentBookingData;
import med.voll.api.domain.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivePatientValidator implements AppointmentBookingValidator {

    @Autowired
    private PatientRepository repository;

    public void validate(AppointmentBookingData data) {
        var patient = data.idDoctor();

        if (patient == null) {
            return;
        }

        boolean isPatientActive = repository.findActiveById(patient);
        if (!isPatientActive) {
            throw new ValidationException("The given doctor is not active!");
        }
    }
}
