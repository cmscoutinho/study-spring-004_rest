package med.voll.api.domain.appointment.validations.booking;

import med.voll.api.domain.ValidationException;
import med.voll.api.domain.appointment.AppointmentBookingData;
import med.voll.api.domain.appointment.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorWithAnotherAppointmentAtSameTimeValidator implements AppointmentBookingValidator {

    @Autowired
    private AppointmentRepository repository;

    public void validate(AppointmentBookingData data) {
        var doctorHasAnotherAppointmentAtSameTime = repository.existsByDoctorIdAndDateAndCancellationReasonIsNull(data.idDoctor(), data.date());
        if(doctorHasAnotherAppointmentAtSameTime) {
            throw new ValidationException("Doctor already has another appointment at the same time!");
        }
    }
}
