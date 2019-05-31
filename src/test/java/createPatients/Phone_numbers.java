package createPatients;

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
}
