package med.voll.api.model.patient;

import med.voll.api.model.address.Address;

public record PatientUpdateData(
        String name,
        String phone,
        Address address
) {
}
