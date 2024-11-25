package med.voll.api.model.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String neighbourhood;
    private String zipCode;
    private String city;
    private String state;
    private String additionalInfo;
    private String number;
}
