package med.voll.api.domain.appointment.validations.booking;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentBookingData;
import med.voll.api.domain.appointment.validations.booking.AppointmentBookingValidator;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("PrecedingTimeBookingValidator")
public class PrecedingTimeValidator implements AppointmentBookingValidator {

    public void validate(AppointmentBookingData data) {
        var appointmentDate = data.date();
        var now = LocalDateTime.now();
        var minuteDifference = Duration.between(now, appointmentDate).toMinutes();

        if (minuteDifference < 30) {
            throw new ValidationException("The appointment must booked at least 30 minutes before.");
        }
    }
}
