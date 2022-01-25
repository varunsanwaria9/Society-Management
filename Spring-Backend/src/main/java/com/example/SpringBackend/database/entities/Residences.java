package com.example.SpringBackend.database.entities;

import javax.persistence.*;

@Entity
public class Residences{

    @Id
    @GeneratedValue
    private int residence_id;
    private int floor_no;
    private int flat_no;
    private String type;
    private int tower_ref;
    // @Column
    // @ElementCollection(targetClass = Parkings.class)
    // private List<Parkings> parkings;
    

    public Residences() {
    }

    public Residences(int floor_no, int flat_no, String type, int tower_ref) {
        this.floor_no = floor_no;
        this.flat_no = flat_no;
        this.type = type;
        this.tower_ref = tower_ref;
    }

    public Residences(int residence_id, int floor_no, int flat_no, String type, int tower_ref) {
        this.residence_id = residence_id;
        this.floor_no = floor_no;
        this.flat_no = flat_no;
        this.type = type;
        this.tower_ref = tower_ref;
    }


    public int getResidence_id() {
        return this.residence_id;
    }

    public void setResidence_id(int residence_id) {
        this.residence_id = residence_id;
    }

    public int getFloor_no() {
        return this.floor_no;
    }

    public void setFloor_no(int floor_no) {
        this.floor_no = floor_no;
    }

    public int getFlat_no() {
        return this.flat_no;
    }

    public void setFlat_no(int flat_no) {
        this.flat_no = flat_no;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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
            " residence_id='" + getResidence_id() + "'" +
            ", floor_no='" + getFloor_no() + "'" +
            ", flat_no='" + getFlat_no() + "'" +
            ", type='" + getType() + "'" +
            ", tower_ref='" + getTower_ref() + "'" +
            "}";
    }

}