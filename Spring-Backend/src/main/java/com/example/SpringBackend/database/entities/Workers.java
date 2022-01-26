package com.example.SpringBackend.database.entities;

import javax.persistence.*;

import com.example.SpringBackend.database.enums.WorkerDept;

@Entity
public class Workers {

    @Id
    @GeneratedValue
    private long worker_id;
    private String name;
    private String phone;
    private String address;
    private WorkerDept department;
    private long manager_ref;
    private int tower_ref;

    public Workers() {
    }

    public Workers(String name, String phone, String address, WorkerDept department, long manager_ref, int tower_ref) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.department = department;
        this.manager_ref = manager_ref;
        this.tower_ref = tower_ref;
    }

    public Workers(long worker_id, String name, String phone, String address, WorkerDept department, long manager_ref, int tower_ref) {
        this.worker_id = worker_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.department = department;
        this.manager_ref = manager_ref;
        this.tower_ref = tower_ref;
    }

    public long getWorker_id() {
        return this.worker_id;
    }

    public void setWorker_id(long worker_id) {
        this.worker_id = worker_id;
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

    public WorkerDept getDepartment() {
        return this.department;
    }

    public void setDepartment(WorkerDept department) {
        this.department = department;
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
            " worker_id='" + getWorker_id() + "'" +
            ", name='" + getName() + "'" +
            ", phone='" + getPhone() + "'" +
            ", address='" + getAddress() + "'" +
            ", department='" + getDepartment() + "'" +
            ", manager_ref='" + getManager_ref() + "'" +
            ", tower_ref='" + getTower_ref() + "'" +
            "}";
    }
    
}
