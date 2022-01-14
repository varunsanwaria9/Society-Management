package com.example.SpringBackend.database.entities;

import javax.persistence.*;

@Entity
public class Parkings {
    
    @Id
    @GeneratedValue
    private int parking_id;
    private String parking_no;
    private String vehicle_no;
    private String vehicle_type;
    private int tower_ref;

    public Parkings() {
    }

    public Parkings(String parking_no, String vehicle_no, String vehicle_type, int tower_ref) {
        this.parking_no = parking_no;
        this.vehicle_no = vehicle_no;
        this.vehicle_type = vehicle_type;
        this.tower_ref = tower_ref;
    }

    public Parkings(int parking_id, String parking_no, String vehicle_no, String vehicle_type, int tower_ref) {
        this.parking_id = parking_id;
        this.parking_no = parking_no;
        this.vehicle_no = vehicle_no;
        this.vehicle_type = vehicle_type;
        this.tower_ref = tower_ref;
    }

    public int getParking_id() {
        return this.parking_id;
    }

    public void setParking_id(int parking_id) {
        this.parking_id = parking_id;
    }

    public String getParking_no() {
        return this.parking_no;
    }

    public void setParking_no(String parking_no) {
        this.parking_no = parking_no;
    }

    public String getVehicle_no() {
        return this.vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getVehicle_type() {
        return this.vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
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
            " parking_id='" + getParking_id() + "'" +
            ", parking_no='" + getParking_no() + "'" +
            ", vehicle_no='" + getVehicle_no() + "'" +
            ", vehicle_type='" + getVehicle_type() + "'" +
            ", tower_ref='" + getTower_ref() + "'" +
            "}";
    }

}
