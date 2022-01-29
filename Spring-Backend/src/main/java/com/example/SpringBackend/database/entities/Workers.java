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
    @OneToOne
    @JoinColumn(name = "manager_ref")
    private Managers manager_ref;
    @OneToOne
    @JoinColumn(name = "tower_ref")
    private Towers tower_ref;

    public Workers() {
    }

    public Workers(String name, String phone, String address, WorkerDept department) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.department = department;
    }

    public Workers(long worker_id, String name, String phone, String address, WorkerDept department,
            Managers manager_ref, Towers tower_ref) {
        this.worker_id = worker_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.department = department;
        this.manager_ref = manager_ref;
        this.tower_ref = tower_ref;
    }

    public long getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(long worker_id) {
        this.worker_id = worker_id;
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

    public WorkerDept getDepartment() {
        return department;
    }

    public void setDepartment(WorkerDept department) {
        this.department = department;
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
        return "Workers [address=" + address + ", department=" + department + ", manager_ref=" + manager_ref + ", name="
                + name + ", phone=" + phone + ", tower_ref=" + tower_ref + ", worker_id=" + worker_id + "]";
    }
    
}
