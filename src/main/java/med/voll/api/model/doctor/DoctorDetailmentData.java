package med.voll.api.model.doctor;

import med.voll.api.model.address.Address;

public record DoctorDetailmentData(String name, String email, String crm, String phone, Speciality speciality, Address address) {

    public DoctorDetailmentData(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhone(), doctor.getSpeciality(), doctor.getAddress());
    }
}
