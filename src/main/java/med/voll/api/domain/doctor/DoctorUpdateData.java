package med.voll.api.domain.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.AddressData;

public record DoctorUpdateData(
        @NotNull
        Long id,

        String name,
        String phone,
        AddressData address
) {
}
