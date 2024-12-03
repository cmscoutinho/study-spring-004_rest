package med.voll.api.model.doctor;

public record DoctorListData(String name, String email, String crm, Speciality speciality) {

    public DoctorListData(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpeciality());
    }
}
