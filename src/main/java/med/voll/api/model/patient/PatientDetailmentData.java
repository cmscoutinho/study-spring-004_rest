package med.voll.api.model.patient;

import jakarta.persistence.Embedded;
import med.voll.api.model.address.Address;

public record PatientDetailmentData(Long id, String name, String email, String phone, String cpf, Address address) {

    public PatientDetailmentData(Patient patient) {
    }
}
