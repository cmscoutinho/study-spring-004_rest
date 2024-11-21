package med.voll.api.model.doctor;

import med.voll.api.model.Address;

public record DoctorRegistryData (String name, String email, String crm, Speciality speciality, Address address) {}
