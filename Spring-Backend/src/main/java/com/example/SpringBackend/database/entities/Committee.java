package com.example.SpringBackend.database.entities;

import javax.persistence.*;

@Entity
public class Committee {

    @Id
    @GeneratedValue
    private long comm_id;
    private String comm_name;

    public Committee() {
    }

    public Committee(String comm_name) {
        this.comm_name = comm_name;
    }

    public Committee(long comm_id, String comm_name) {
        this.comm_id = comm_id;
        this.comm_name = comm_name;
    }

    public long getComm_id() {
        return this.comm_id;
    }

    public void setComm_id(long comm_id) {
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
