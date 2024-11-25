package med.voll.api.model.patient;

import med.voll.api.model.address.AddressData;

public record PatientRegistryData(String name,
                                  String email,
                                  String phone,
                                  String cpf,
                                  AddressData address) {
}
