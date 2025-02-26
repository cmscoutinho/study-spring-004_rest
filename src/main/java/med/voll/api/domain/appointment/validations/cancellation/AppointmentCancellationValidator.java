package med.voll.api.domain.appointment.validations.cancellation;

import med.voll.api.domain.appointment.AppointmentCancellationData;

public interface AppointmentCancellationValidator {
    void validate(AppointmentCancellationData data);
}
