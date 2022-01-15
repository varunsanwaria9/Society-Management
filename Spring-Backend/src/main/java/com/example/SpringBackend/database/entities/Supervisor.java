package com.example.SpringBackend.database.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supervisor {
    
    @Id
    private int supervisor_id;
    private String first_name;
    private String last_name;
    private String gender;
    private String phone_no;
    private String address;
    private int auth_ref;


    public Supervisor() {
    }


    public Supervisor(String first_name, String last_name, String gender, String phone_no, String address, int auth_ref) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.phone_no = phone_no;
        this.address = address;
        this.auth_ref = auth_ref;
    }

    public Supervisor(int supervisor_id, String first_name, String last_name, String gender, String phone_no, String address, int auth_ref) {
        this.supervisor_id = supervisor_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.phone_no = phone_no;
        this.address = address;
        this.auth_ref = auth_ref;
    }


    public int getSupervisor_id() {
        return this.supervisor_id;
    }

    public void setSupervisor_id(int supervisor_id) {
        this.supervisor_id = supervisor_id;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAuth_ref() {
        return this.auth_ref;
    }

    public void setAuth_ref(int auth_ref) {
        this.auth_ref = auth_ref;
    }

    @Override
    public String toString() {
        return "{" +
            " supervisor_id='" + getSupervisor_id() + "'" +
            ", first_name='" + getFirst_name() + "'" +
            ", last_name='" + getLast_name() + "'" +
            ", gender='" + getGender() + "'" +
            ", phone_no='" + getPhone_no() + "'" +
            ", address='" + getAddress() + "'" +
            ", auth_ref='" + getAuth_ref() + "'" +
            "}";
    }

}
