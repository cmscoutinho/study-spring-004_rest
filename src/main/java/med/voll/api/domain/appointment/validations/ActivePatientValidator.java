package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentBookingData;
import med.voll.api.domain.patient.PatientRepository;

public class ActivePatientValidator implements AppointmentBookingValidator {

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
