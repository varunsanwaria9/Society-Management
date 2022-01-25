package com.example.SpringBackend.database.entities;

import javax.persistence.*;

@Entity
public class Supervisor {
    
    @Id
    @GeneratedValue
    private long supervisor_id;
    private String name;
    private String phone;
    private String address;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_id")
    private Auth auth;

    public Supervisor() {
    }

    public Supervisor(String name, String phone, String address, Auth auth) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.auth = auth;
    }

    public Supervisor(long supervisor_id, String name, String phone, String address, Auth auth) {
        this.supervisor_id = supervisor_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.auth = auth;
    }

    public long getSupervisor_id() {
        return this.supervisor_id;
    }

    public void setSupervisor_id(long supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
            " supervisor_id='" + getSupervisor_id() + "'" +
            ", name='" + getName() + "'" +
            ", phone='" + getPhone() + "'" +
            ", address='" + getAddress() + "'" +
            ", auth='" + getAuth() + "'" +
            "}";
    }

}
