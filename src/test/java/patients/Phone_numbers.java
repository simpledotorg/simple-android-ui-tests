package patients;

import lombok.Getter;
import lombok.Setter;
import utils.RandomValue;

@Getter
@Setter
public class Phone_numbers {
    private String number;
    private String phone_type;
    private String updated_at;
    private Boolean active;
    private String created_at;
    private String id;
    private String deleted_at;

    public Phone_numbers(String number, String phone_type, String updated_at, Boolean active, String created_at, String id, String deleted_at) {
        this.number = number;
        this.phone_type = phone_type;
        this.updated_at = updated_at;
        this.active = active;
        this.created_at = created_at;
        this.id = id;
        this.deleted_at = deleted_at;
    }

    public static class Builder {

        private String number=RandomValue.getRandomPhoneNumber();
        private String phone_type;
        private String updated_at = "2019-05-29T05:39:35Z";
        private Boolean active = true;
        private String created_at = "2019-05-29T05:39:35Z";
        private String id = RandomValue.getRandomPhoneNumberId();
        private String deleted_at = "";


        public Builder() {
        }

        public Builder withActive(Boolean value) {
            this.active = value;
            return this;
        }

        public Builder withUpdatedAt(String value) {
            this.updated_at = value;
            return this;
        }

        public Builder withCreatedAt(String value) {
            this.created_at = value;
            return this;
        }

        public Builder withPhoneType(String value) {
            this.phone_type = value;
            return this;
        }

        public Builder withPhoneNumber(String value) {
            this.number = value;
            return this;
        }

        public Phone_numbers Build() {
            return new Phone_numbers(number, phone_type, updated_at, active, created_at, id, deleted_at);
        }
    }
}
