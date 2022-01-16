package com.example.SpringBackend.database.entities;

import javax.persistence.*;

@Entity
public class Society_Auth {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int soc_auth_id;
    private String first_name;
    private String last_name;
    private String genders;
    private String phone_no;
    private String address;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_id")
    private Auth auth;


    public Society_Auth() {
    }

    public Society_Auth(String first_name, String last_name, String genders, String phone_no, String address, Auth auth) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.genders = genders;
        this.phone_no = phone_no;
        this.address = address;
        this.auth = auth;
    }

    public Society_Auth(int soc_auth_id, String first_name, String last_name, String genders, String phone_no, String address, Auth auth) {
        this.soc_auth_id = soc_auth_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.genders = genders;
        this.phone_no = phone_no;
        this.address = address;
        this.auth = auth;
    }

    public int getSoc_auth_id() {
        return this.soc_auth_id;
    }

    public void setSoc_auth_id(int soc_auth_id) {
        this.soc_auth_id = soc_auth_id;
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

    public String getGenders() {
        return this.genders;
    }

    public void setGenders(String genders) {
        this.genders = genders;
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

    public Auth getAuth() {
        return this.auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "{" +
            " soc_auth_id='" + getSoc_auth_id() + "'" +
            ", first_name='" + getFirst_name() + "'" +
            ", last_name='" + getLast_name() + "'" +
            ", genders='" + getGenders() + "'" +
            ", phone_no='" + getPhone_no() + "'" +
            ", address='" + getAddress() + "'" +
            ", auth='" + getAuth() + "'" +
            "}";
    }

}
