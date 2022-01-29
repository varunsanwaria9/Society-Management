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
    @OneToOne
    @JoinColumn(name = "tower_ref")
    private Towers tower_ref;
    @OneToOne
    @JoinColumn(name = "supervisor_ref")
    private Supervisor supervisor_ref;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_id")
    private Auth auth;

    public Managers() {
    }

    public Managers(String name, String phone, String address, Auth auth) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.auth = auth;
    }

    public Managers(long manager_id, String name, String phone, String address, Towers tower_ref,
            Supervisor supervisor_ref, Auth auth) {
        this.manager_id = manager_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.tower_ref = tower_ref;
        this.supervisor_ref = supervisor_ref;
        this.auth = auth;
    }

    public long getManager_id() {
        return manager_id;
    }

    public void setManager_id(long manager_id) {
        this.manager_id = manager_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Towers getTower_ref() {
        return tower_ref;
    }

    public void setTower_ref(Towers tower_ref) {
        this.tower_ref = tower_ref;
    }

    public Supervisor getSupervisor_ref() {
        return supervisor_ref;
    }

    public void setSupervisor_ref(Supervisor supervisor_ref) {
        this.supervisor_ref = supervisor_ref;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "Managers [address=" + address + ", auth=" + auth + ", manager_id=" + manager_id + ", name=" + name
                + ", phone=" + phone + ", supervisor_ref=" + supervisor_ref + ", tower_ref=" + tower_ref + "]";
    }


}
