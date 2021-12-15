package com.example.societybackend.databases.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity 
@ToString
public class Person{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String first_name;
    private String last_name;
    private String gender;
    private String phone;
    private String dob;
    private String flatNo;

    @Column
    @ElementCollection(targetClass = Vehicle.class)
    private List<Vehicle> vehicles;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_id")
    private Auth auth;

    public Person() {
    }


    public Person(String first_name,
                  String last_name,
                  String gender,
                  String phone,
                  String dob,
                  String flatNo,
                  List<Vehicle> vehicles,
                  Auth auth) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.phone = phone;
        this.dob = dob;
        this.flatNo = flatNo;
        this.vehicles = vehicles;
        this.auth = auth;
    }

    public Person(String id,
                  String first_name,
                  String last_name,
                  String gender,
                  String phone,
                  String dob,
                  String flatNo,
                  List<Vehicle> vehicles,
                  Auth auth) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.phone = phone;
        this.dob = dob;
        this.flatNo = flatNo;
        this.vehicles = vehicles;
        this.auth = auth;
    }


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getFlatNo() {
		return flatNo;
	}


	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}


	public List<Vehicle> getVehicles() {
		return vehicles;
	}


	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}


	public Auth getAuth() {
		return auth;
	}


	public void setAuth(Auth auth) {
		this.auth = auth;
	}

}
