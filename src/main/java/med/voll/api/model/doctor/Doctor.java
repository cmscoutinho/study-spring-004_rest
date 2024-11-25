package med.voll.api.model.doctor;

import jakarta.persistence.*;
import med.voll.api.model.address.AddressData;

@Entity(name = "Doctor")
@Table(name = "doctors")
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @Embedded
    private AddressData address;
}
