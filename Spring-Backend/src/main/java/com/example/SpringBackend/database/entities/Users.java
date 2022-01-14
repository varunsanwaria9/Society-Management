package com.example.SpringBackend.database.entities;

import javax.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String first_name;
    private String last_name;
    private String gender;
    private String phone_no;
    private int residence_details;
    private long auth_details;

}
