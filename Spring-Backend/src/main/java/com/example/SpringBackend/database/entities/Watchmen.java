package com.example.SpringBackend.database.entities;

import javax.persistence.*;

@Entity
public class Watchmen {
    
    @Id
    @GeneratedValue
    private long watchmen_id;
    private String name;
    private String phone;
    private String address;
    @OneToOne
    @JoinColumn(name = "manager_ref")
    private Managers manager_ref;
    @OneToOne
    @JoinColumn(name = "tower_ref")
    private Towers tower_ref;

    public Watchmen() {
    }

    public Watchmen(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Watchmen(long watchmen_id, String name, String phone, String address, Managers manager_ref,
            Towers tower_ref) {
        this.watchmen_id = watchmen_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.manager_ref = manager_ref;
        this.tower_ref = tower_ref;
    }

    public long getWatchmen_id() {
        return watchmen_id;
    }

    public void setWatchmen_id(long watchmen_id) {
        this.watchmen_id = watchmen_id;
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

    public Managers getManager_ref() {
        return manager_ref;
    }

    public void setManager_ref(Managers manager_ref) {
        this.manager_ref = manager_ref;
    }

    public Towers getTower_ref() {
        return tower_ref;
    }

    public void setTower_ref(Towers tower_ref) {
        this.tower_ref = tower_ref;
    }

    @Override
    public String toString() {
        return "Watchmen [address=" + address + ", manager_ref=" + manager_ref + ", name=" + name + ", phone=" + phone
                + ", tower_ref=" + tower_ref + ", watchmen_id=" + watchmen_id + "]";
    }

}
