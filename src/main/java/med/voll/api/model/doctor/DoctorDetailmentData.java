package med.voll.api.model.doctor;

import med.voll.api.model.address.Address;

public record DoctorDetailmentData(Long id, String name, String email, String crm, String phone, Speciality speciality, Address address) {

    public DoctorDetailmentData(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhone(), doctor.getSpeciality(), doctor.getAddress());
    }
}
