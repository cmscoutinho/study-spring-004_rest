package med.voll.api.model.patient;

public record PatientListData(String name, String email, String phone) {

    public PatientListData(Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getPhone());
    }
}
