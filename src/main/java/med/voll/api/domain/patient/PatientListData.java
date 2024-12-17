package med.voll.api.domain.patient;

public record PatientListData(Long id, String name, String email, String phone) {

    public PatientListData(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone());
    }
}
