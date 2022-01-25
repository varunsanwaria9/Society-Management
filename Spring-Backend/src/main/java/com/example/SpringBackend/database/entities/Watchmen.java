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
    private long manager_ref;
    private int tower_ref;

    public Watchmen() {
    }

    public Watchmen(String name, String phone, String address, long manager_ref, int tower_ref) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.manager_ref = manager_ref;
        this.tower_ref = tower_ref;
    }

    public Watchmen(long watchmen_id, String name, String phone, String address, long manager_ref, int tower_ref) {
        this.watchmen_id = watchmen_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.manager_ref = manager_ref;
        this.tower_ref = tower_ref;
    }

    public long getWatchmen_id() {
        return this.watchmen_id;
    }

    public void setWatchmen_id(long watchmen_id) {
        this.watchmen_id = watchmen_id;
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

    public long getManager_ref() {
        return this.manager_ref;
    }

    public void setManager_ref(long manager_ref) {
        this.manager_ref = manager_ref;
    }

    public int getTower_ref() {
        return this.tower_ref;
    }

    public void setTower_ref(int tower_ref) {
        this.tower_ref = tower_ref;
    }

    @Override
    public String toString() {
        return "{" +
            " watchmen_id='" + getWatchmen_id() + "'" +
            ", name='" + getName() + "'" +
            ", phone='" + getPhone() + "'" +
            ", address='" + getAddress() + "'" +
            ", manager_ref='" + getManager_ref() + "'" +
            ", tower_ref='" + getTower_ref() + "'" +
            "}";
    }

}
