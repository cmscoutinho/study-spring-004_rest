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

    public Address(AddressData address) {
        this.street = address.street();
        this.neighbourhood = address.neighbourhood();
        this.zipCode = address.zipCode();
        this.city = address.city();
        this.state = address.state();
        this.additionalInfo = address.additionalInfo();
        this.number = address.number();
    }

    public void updateInfo(AddressData data) {
        if (data.street() != null) {
            this.street = data.street();
        }
        if (data.neighbourhood() != null) {
            this.neighbourhood = data.neighbourhood();
        }
        if (data.zipCode() != null) {
            this.zipCode = data.zipCode();
        }
        if (data.state() != null) {
            this.street = data.state();
        }
        if (data.city() != null) {
            this.city = data.city();
        }
        if (data.number() != null) {
            this.number = data.number();
        }
        if (data.additionalInfo() != null) {
            this.additionalInfo = data.additionalInfo();
        }
    }
}
