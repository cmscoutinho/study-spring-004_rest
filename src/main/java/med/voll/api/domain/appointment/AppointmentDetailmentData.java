package med.voll.api.domain.appointment;

import java.time.LocalDateTime;

public record AppointmentDetailmentData(Long id, Long idDoctor, Long idPatient, LocalDateTime date) {
    public AppointmentDetailmentData(Appointment appointment) {
        this(appointment.getId(), appointment.getDoctor().getId(), appointment.getPatient().getId(), appointment.getDate());    }
}
