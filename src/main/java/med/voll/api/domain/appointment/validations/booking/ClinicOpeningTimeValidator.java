package med.voll.api.domain.appointment.validations.booking;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentBookingData;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ClinicOpeningTimeValidator implements AppointmentBookingValidator {

    public void validate(AppointmentBookingData data) {
        var appointmentDate = data.date();

        var isSunday = appointmentDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var isBeforeOpening = appointmentDate.getHour() < 7;
        var isAfterClosing = appointmentDate.getHour() > 18;

        if(isSunday || isBeforeOpening || isAfterClosing) {
            throw new ValidationException("Appointment outside the clinic's operating hours.");
        }
    }
}
