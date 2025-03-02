package med.voll.api.domain.appointment.validations.cancellation;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentCancellationData;

import java.time.Duration;
import java.time.LocalDateTime;

public class PrecedingTimeValidator implements AppointmentCancellationValidator{

    @Override
    public void validate(AppointmentCancellationData data) {
        var appointment = repository.getReferenceById(data.idAppointment());
        var now = LocalDateTime.now();
        var hourDifference = Duration.between(now, appointment.getData()).toHours();

        if (hourDifference < 24) {
            throw new ValidationException("Appointments might be cancelled only up to 24 hours before!");
        }
    }
}
