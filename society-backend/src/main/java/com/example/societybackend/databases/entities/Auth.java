package com.example.societybackend.databases.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Auth {

    @Id
    private String id;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Roles> roles = new ArrayList<>();
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    private Person user;

    public Auth() {
    }

    public Auth(String email,
                String password,
                List<Roles> roles,
                Person user ) {
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.user = user;
    }

    public Auth(String id,
                String email,
                String password,
                List<Roles> roles,
                Person user) {
        this.id = id;
        this.user = user;
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

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", user=" + user +
                '}';
    }
}
