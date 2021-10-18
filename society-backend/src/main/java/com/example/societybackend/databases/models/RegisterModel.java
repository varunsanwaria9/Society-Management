package com.example.societybackend.databases.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class RegisterModel {

    private String first_name;
    private String last_name;
    private String gender;
    private String dob;
    private String phone;
    private String email;
    private String password;

    public RegisterModel() {
    }

    public RegisterModel(String first_name,
                         String last_name,
                         String gender,
                         String dob,
                         String phone,
                         String email,
                         String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

}
