package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentBookingData;
import med.voll.api.domain.appointment.AppointmentRepository;
import org.springframework.stereotype.Component;

@Component
public class PatientWithNoAppointmentsOnSameDayValidator implements AppointmentBookingValidator {

    AppointmentRepository repository;

    public void validate(AppointmentBookingData data) {
        var startTime = data.date().withHour(7);
        var finalTime = data.date().withHour(18);
        var appointmentExists = repository.existsByPatientIdAndDateBetween(data.idPatient(), startTime, finalTime);
        if(appointmentExists) {
            throw new ValidationException("Patient already has another appointment in the same day!");
        }
    }
}
