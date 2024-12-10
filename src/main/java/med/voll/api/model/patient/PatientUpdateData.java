package med.voll.api.model.patient;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.address.Address;

public record PatientUpdateData(
        @NotNull
        Long id,

        String name,
        String phone,
        Address address
) {
}
