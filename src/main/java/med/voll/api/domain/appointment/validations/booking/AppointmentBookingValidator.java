package med.voll.api.domain.appointment.validations.booking;

import med.voll.api.domain.appointment.AppointmentBookingData;

public interface AppointmentBookingValidator {

    void validate(AppointmentBookingData data);
}
