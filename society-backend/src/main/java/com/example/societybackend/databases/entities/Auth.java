package com.example.societybackend.databases.entities;

import javax.persistence.*;

@Entity
public class Auth {

    @Id
    private String id;
    private String email;
    private String password;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    private Users user;

    public Auth() {
    }

    public Auth(String email, String password, Users user) {
        this.email = email;
        this.password = password;
        this.user = user;
    }

    public Auth(String id, String email, String password, Users user) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.user = user;
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", user=" + user +
                '}';
    }
}
