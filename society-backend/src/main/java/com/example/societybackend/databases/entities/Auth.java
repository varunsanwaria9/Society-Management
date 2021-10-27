package com.example.societybackend.databases.entities;


import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Auth {

    @Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	private String id;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Roles> roles = new ArrayList<>();

    public Auth() {
    }

    public Auth(String email,
                String password,
                List<Roles> roles){
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Auth(String id,
                String email,
                String password,
                List<Roles> roles){
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
