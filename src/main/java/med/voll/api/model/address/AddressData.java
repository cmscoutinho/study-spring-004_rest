package med.voll.api.model.address;

public record AddressData(String street,
                          String neighbourhood,
                          String zipCode,
                          String city,
                          String state,
                          String additionalInfo,
                          String number) {
}
