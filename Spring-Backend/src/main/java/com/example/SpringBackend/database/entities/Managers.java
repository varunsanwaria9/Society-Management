package com.example.SpringBackend.database.entities;

import javax.persistence.*;

@Entity
public class Managers {
    
    @Id
    @GeneratedValue
    private long manager_id;
    private String name;
    private String phone;
    private String address;
    private int tower_ref;
    private long supervisor_ref;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_id")
    private Auth auth;

    public Managers() {
    }

    public Managers(String name, String phone, String address, int tower_ref, long supervisor_ref, Auth auth) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.tower_ref = tower_ref;
        this.supervisor_ref = supervisor_ref;
        this.auth = auth;
    }

    public Managers(long manager_id, String name, String phone, String address, int tower_ref, long supervisor_ref, Auth auth) {
        this.manager_id = manager_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.tower_ref = tower_ref;
        this.supervisor_ref = supervisor_ref;
        this.auth = auth;
    }

    public long getManager_id() {
        return this.manager_id;
    }

    public void setManager_id(long manager_id) {
        this.manager_id = manager_id;
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

    public int getTower_ref() {
        return this.tower_ref;
    }

    public void setTower_ref(int tower_ref) {
        this.tower_ref = tower_ref;
    }

    public long getSupervisor_ref() {
        return this.supervisor_ref;
    }

    public void setSupervisor_ref(long supervisor_ref) {
        this.supervisor_ref = supervisor_ref;
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
            " manager_id='" + getManager_id() + "'" +
            ", name='" + getName() + "'" +
            ", phone='" + getPhone() + "'" +
            ", address='" + getAddress() + "'" +
            ", tower_ref='" + getTower_ref() + "'" +
            ", supervisor_ref='" + getSupervisor_ref() + "'" +
            ", auth='" + getAuth() + "'" +
            "}";
    }

}
