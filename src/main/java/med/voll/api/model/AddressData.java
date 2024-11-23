package med.voll.api.model;

public record AddressData(String street,
                          String neighbourhood,
                          String zipCode,
                          String city,
                          String state,
                          String additionalInfo,
                          String number) {
}
