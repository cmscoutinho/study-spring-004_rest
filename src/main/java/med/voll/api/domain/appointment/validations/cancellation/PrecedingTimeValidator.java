package med.voll.api.domain.appointment.validations.cancellation;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentCancellationData;
import med.voll.api.domain.appointment.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("PrecedingTimeCancellationValidator")
public class PrecedingTimeValidator implements AppointmentCancellationValidator{


    @Autowired
    private AppointmentRepository repository;

    @Override
    public void validate(AppointmentCancellationData data) {
        var appointment = repository.getReferenceById(data.idAppointment());
        var now = LocalDateTime.now();
        var hourDifference = Duration.between(now, appointment.getDate()).toHours();

        if (hourDifference < 24) {
            throw new ValidationException("Appointments may be cancelled only up to 24 hours before!");
        }
    }
}
