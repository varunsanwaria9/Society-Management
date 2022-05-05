package com.example.SpringBackend.database.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Committee {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String comm_id;
    private String comm_name;

    public Committee() {
    }

    public Committee(String comm_name) {
        this.comm_name = comm_name;
    }

    public Committee(String comm_id, String comm_name) {
        this.comm_id = comm_id;
        this.comm_name = comm_name;
    }

    public String getComm_id() {
        return this.comm_id;
    }

    public void setComm_id(String comm_id) {
        this.comm_id = comm_id;
    }

    public String getComm_name() {
        return this.comm_name;
    }

    public void setComm_name(String comm_name) {
        this.comm_name = comm_name;
    }

    @Override
    public String toString() {
        return "{" +
            " comm_id='" + getComm_id() + "'" +
            ", comm_name='" + getComm_name() + "'" +
            "}";
    }

}
