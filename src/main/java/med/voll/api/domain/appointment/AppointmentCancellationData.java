package med.voll.api.domain.appointment;

import jakarta.validation.constraints.NotBlank;

public record AppointmentCancellationData(

        Long idAppointment,

        @NotBlank
        String reason
) {
}
