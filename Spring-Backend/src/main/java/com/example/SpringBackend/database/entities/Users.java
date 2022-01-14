package com.example.SpringBackend.database.entities;

import javax.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String first_name;
    private String last_name;
    private String gender;
    private String phone_no;
    private int residence_details;
    private long auth_details;


    public Users() {
    }

    public Users(String first_name, String last_name, String gender, String phone_no, int residence_details, long auth_details) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.phone_no = phone_no;
        this.residence_details = residence_details;
        this.auth_details = auth_details;
    }

    public Users(Long id, String first_name, String last_name, String gender, String phone_no, int residence_details, long auth_details) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.phone_no = phone_no;
        this.residence_details = residence_details;
        this.auth_details = auth_details;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_no() {
        return this.phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public int getResidence_details() {
        return this.residence_details;
    }

    public void setResidence_details(int residence_details) {
        this.residence_details = residence_details;
    }

    public long getAuth_details() {
        return this.auth_details;
    }

    public void setAuth_details(long auth_details) {
        this.auth_details = auth_details;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", first_name='" + getFirst_name() + "'" +
            ", last_name='" + getLast_name() + "'" +
            ", gender='" + getGender() + "'" +
            ", phone_no='" + getPhone_no() + "'" +
            ", residence_details='" + getResidence_details() + "'" +
            ", auth_details='" + getAuth_details() + "'" +
            "}";
    }

}
