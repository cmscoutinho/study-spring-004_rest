package med.voll.api.model.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.address.AddressData;

public record DoctorUpdateData(
        @NotNull
        Long id,

        String name,
        String phone,
        AddressData address
) {
}
