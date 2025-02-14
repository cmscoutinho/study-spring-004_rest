package med.voll.api.domain.appointment.validations;

import med.voll.api.domain.appointment.AppointmentBookingData;

public interface AppointmentBookingValidator {

    void validate(AppointmentBookingData data);
}
