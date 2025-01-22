package med.voll.api.domain.appointment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AppointmentCancellationData(

        @NotNull
        Long idAppointment,

        @NotBlank
        CancellationReason reason
) {
}
