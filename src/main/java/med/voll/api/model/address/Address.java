package med.voll.api.model.address;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String neighbourhood;
    private String zipCode;
    private String city;
    private String state;
    private String additionalInfo;
    private String number;
}
