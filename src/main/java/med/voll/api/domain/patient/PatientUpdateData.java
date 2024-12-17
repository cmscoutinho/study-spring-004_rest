package med.voll.api.domain.patient;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.Address;

public record PatientUpdateData(
        @NotNull
        Long id,

        String name,
        String phone,
        Address address
) {
}
