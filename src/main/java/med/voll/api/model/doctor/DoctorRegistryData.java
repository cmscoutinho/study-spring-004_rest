package med.voll.api.model.doctor;

import med.voll.api.model.AddressData;

public record DoctorRegistryData (String name, String email, String crm, Speciality speciality, AddressData addressData) {}
