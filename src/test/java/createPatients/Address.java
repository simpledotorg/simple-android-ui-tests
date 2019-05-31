package createPatients;

public class Address {
    private String street_address;
    private String country;
    private String pin;
    private String updated_at;
    private String district;
    private String created_at;
    private String id;
    private String state;
    private String deleted_at;
    private String village_or_colony;

    public Address(String street_address, String country, String pin, String updated_at, String district, String created_at, String id, String state, String deleted_at, String village_or_colony) {
        this.street_address = street_address;
        this.country = country;
        this.pin = pin;
        this.updated_at = updated_at;
        this.district = district;
        this.created_at = created_at;
        this.id = id;
        this.state = state;
        this.deleted_at = deleted_at;
        this.village_or_colony = village_or_colony;
    }
}
