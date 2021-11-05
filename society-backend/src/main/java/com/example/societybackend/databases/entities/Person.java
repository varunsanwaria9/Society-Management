package com.example.societybackend.databases.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity 
@Getter 
@Setter 
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
    @ElementCollection(targetClass = String.class)
    private List<String> vehicles;

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
                  List<String> vehicles,
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
                  List<String> vehicles,
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
}
