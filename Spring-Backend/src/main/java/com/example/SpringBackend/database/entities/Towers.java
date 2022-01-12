package com.example.SpringBackend.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Towers {
    
    @Id
    @GeneratedValue
    private int tower_id;
    private String tower_name;


    public Towers() {
    }

    public Towers(String tower_name) {
        this.tower_name = tower_name;
    }
    public Towers(int tower_id, String tower_name) {
        this.tower_id = tower_id;
        this.tower_name = tower_name;
    }

    public int getTower_id() {
        return this.tower_id;
    }

    public void setTower_id(int tower_id) {
        this.tower_id = tower_id;
    }

    public String getTower_name() {
        return this.tower_name;
    }

    public void setTower_name(String tower_name) {
        this.tower_name = tower_name;
    }

    @Override
    public String toString() {
        return "{" +
            " tower_id='" + getTower_id() + "'" +
            ", tower_name='" + getTower_name() + "'" +
            "}";
    }    
}

