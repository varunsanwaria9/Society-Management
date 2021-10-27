package com.example.societybackend.databases.entities;

import com.example.societybackend.databases.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity @Getter @Setter @ToString
public class Vehicle {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String reg_no;
    private VehicleType type;

    public Vehicle() {
    }

    public Vehicle(String reg_no, VehicleType type) {
        this.reg_no = reg_no;
        this.type = type;
    }

    public Vehicle(String id, String reg_no, VehicleType type) {
        this.id = id;
        this.reg_no = reg_no; 
		this.type = type;
	}
}
