package createPatients;

import java.util.List;

public class Patients {
    private List<Phone_numbers> phone_numbers;
    private String full_name;
    private Address address;
    private String gender;
    private String updated_at;
    private String date_of_birth;
    private String created_at;
    private String id;
    private String deleted_at;
    private int age;
    private String age_updated_at;
    private String status;

    public Patients(List<Phone_numbers> phone_numbers, String full_name, Address address, String gender, String updated_at, String date_of_birth, String created_at, String id, String deleted_at, int age, String age_updated_at, String status) {
        this.phone_numbers = phone_numbers;
        this.full_name = full_name;
        this.address = address;
        this.gender = gender;
        this.updated_at = updated_at;
        this.date_of_birth = date_of_birth;
        this.created_at = created_at;
        this.id = id;
        this.deleted_at = deleted_at;
        this.age = age;
        this.age_updated_at = age_updated_at;
        this.status = status;
    }
}
