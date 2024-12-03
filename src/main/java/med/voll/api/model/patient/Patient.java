package med.voll.api.model.patient;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import med.voll.api.model.address.AddressData;

@Entity(name = "Patient")
@Table(name = "patients")
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    String name;
    String email;
    String phone;
    String cpf;
    AddressData address;

    public Patient(PatientRegistryData data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.cpf = data.cpf();
        this.address = data.address();
    }
}