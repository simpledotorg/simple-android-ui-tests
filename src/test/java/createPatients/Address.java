package createPatients;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import utils.RandomValue;

@Getter
@Setter
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

    public static class Builder {

        private String street_address="test Street";
        private String country="India";
        private String pin ="1234565";
        private String updated_at="2019-05-29T05:39:35Z";
        private String district="testDistrict";
        private String created_at="2019-05-29T05:39:35Z";
        private String id=RandomValue.getRandomAddressId();
        private String state="test State";
        private String deleted_at="";
        private String village_or_colony="testVillage";

        public Builder(){ }

        public Builder withUpdatedAt(String value){
            this.updated_at=value;
            return this;
        }

        public Builder withCreatedAt(String value){
            this.created_at=value;
            return this;
        }
        public Address Build(){
            return new Address(street_address, country, pin, updated_at, district, created_at, id, state, deleted_at, village_or_colony);
        }

    }
}
