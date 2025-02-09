package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentBookingData;

import java.time.Duration;
import java.time.LocalDateTime;

public class PrecedingTimeValidator {

    public void validate(AppointmentBookingData data) {
        var appointmentDate = data.date();
        var now = LocalDateTime.now();
        var minuteDifference = Duration.between(now, appointmentDate).toMinutes();

        if (minuteDifference < 30) {
            throw new ValidationException("The appointment must booked at least 30 minutes before.");
        }
    }
}
