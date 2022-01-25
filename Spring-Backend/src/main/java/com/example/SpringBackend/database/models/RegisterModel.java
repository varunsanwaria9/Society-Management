package com.example.SpringBackend.database.models;

public class RegisterModel {
    private String name;
    private String phone_no;
    private String email;
    private String password;

    public RegisterModel() {
    }

    public RegisterModel(String name, String phone_no, String email, String password) {
        this.name = name;
        this.phone_no = phone_no;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return this.phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", phone_no='" + getPhone_no() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

}
