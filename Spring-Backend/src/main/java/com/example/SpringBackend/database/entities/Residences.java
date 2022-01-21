package com.example.SpringBackend.database.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Residences{

    @Id
    @GeneratedValue
    private int residence_id;
    private int floor_no;
    private int flat_no;
    private int tower_ref;
    @Column
    @ElementCollection(targetClass = Parkings.class)
    private List<Parkings> parkings;
    
    public Residences() {
    }


    public Residences(int floor_no, int flat_no, int tower_ref, List<Parkings> parkings) {
        this.floor_no = floor_no;
        this.flat_no = flat_no;
        this.tower_ref = tower_ref;
        this.parkings = parkings;
    }

    public Residences(int residence_id, int floor_no, int flat_no, int tower_ref, List<Parkings> parkings) {
        this.residence_id = residence_id;
        this.floor_no = floor_no;
        this.flat_no = flat_no;
        this.tower_ref = tower_ref;
        this.parkings = parkings;
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

    public int getTower_ref() {
        return this.tower_ref;
    }

    public void setTower_ref(int tower_ref) {
        this.tower_ref = tower_ref;
    }

    public List<Parkings> getParkings() {
        return this.parkings;
    }

    public void setParkings(List<Parkings> parkings) {
        this.parkings = parkings;
    }

    @Override
    public String toString() {
        return "{" +
            " residence_id='" + getResidence_id() + "'" +
            ", floor_no='" + getFloor_no() + "'" +
            ", flat_no='" + getFlat_no() + "'" +
            ", tower_ref='" + getTower_ref() + "'" +
            ", parkings='" + getParkings() + "'" +
            "}";
    }

}