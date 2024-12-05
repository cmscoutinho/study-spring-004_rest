package med.voll.api.model.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.address.Address;

public record DoctorUpdateData(
        @NotNull
        Long id,

        String name,
        String phone,
        Address address;
) {
}
