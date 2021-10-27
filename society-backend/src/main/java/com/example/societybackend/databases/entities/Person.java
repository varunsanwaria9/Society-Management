package com.example.societybackend.databases.entities;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

@Entity 
@Getter 
@Setter 
@ToString
public class Person extends Users{

    private String flatNo;
    @OneToMany(targetEntity = Vehicle.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "person_vehicles",referencedColumnName = "id")
    private List<Vehicle> vehicles = new ArrayList<>();
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id",referencedColumnName = "id")
	private Auth auth;	

    public Person() {
    }

    public Person(String first_name,
                  String last_name,
                  String gender,
                  String dob,
                  String phone,
                  String flatNo,
                  List<Vehicle> vehicles,
				  Auth auth) {
        super(first_name, last_name, gender, dob, phone);
        this.flatNo = flatNo;
        this.vehicles = vehicles;
		this.auth = auth;
    }

    public Person(String id,
                  String first_name,
                  String last_name,
                  String gender,
                  String dob,
                  String phone,
                  String flatNo,
                  List<Vehicle> vehicles,
				  Auth auth) {
        super(id, first_name, last_name, gender, dob, phone);
        this.flatNo = flatNo;
        this.vehicles = vehicles;
		this.auth = auth;
    }
}
