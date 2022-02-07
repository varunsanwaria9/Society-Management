package com.example.SpringBackend.database.entities;

import javax.persistence.*;

import com.example.SpringBackend.database.enums.ResidenceType;

@Entity
public class Residences{

    @Id
    @GeneratedValue
    private int residence_id;
    private int floor_no;
    private String flat_no;
    @Enumerated(EnumType.STRING)
    private ResidenceType type;
    @OneToOne
    @JoinColumn(name = "tower_ref")
    private Towers tower_ref;


    public Residences() {
    }

    public Residences(int floor_no, String flat_no, ResidenceType type) {
        this.floor_no = floor_no;
        this.flat_no = flat_no;
        this.type = type;
    }

    public Residences(int residence_id, int floor_no, String flat_no, ResidenceType type, Towers tower_ref) {
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

    public String getFlat_no() {
        return this.flat_no;
    }

    public void setFlat_no(String flat_no) {
        this.flat_no = flat_no;
    }

    public ResidenceType getType() {
        return this.type;
    }

    public void setType(ResidenceType type) {
        this.type = type;
    }

    public Towers getTower_ref() {
        return this.tower_ref;
    }

    public void setTower_ref(Towers tower_ref) {
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