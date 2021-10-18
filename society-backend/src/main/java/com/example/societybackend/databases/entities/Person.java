package com.example.societybackend.databases.entities;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity @Getter @Setter @ToString
public class Person extends Users{

    private String flatNo;

    public Person() {
    }

    public Person(String first_name,
                  String last_name,
                  String gender,
                  LocalDate dob,
                  String phone,
                  String flatNo) {
        super(first_name, last_name, gender, dob, phone);
        this.flatNo = flatNo;
    }

    public Person(String id,
                  String first_name,
                  String last_name,
                  String gender,
                  LocalDate dob,
                  String phone,
                  String flatNo) {
        super(id, first_name, last_name, gender, dob, phone);
        this.flatNo = flatNo;
    }
}
