package com.example.SpringBackend.database.entities;

import javax.persistence.*;

@Entity
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long auth_id;
    private String email;
    private String password;
    private String roles;


    public Auth() {
    }

    public Auth(String email, String password, String roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    
    public Auth(Long auth_id, String email, String password, String roles) {
        this.auth_id = auth_id;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    

    public Long getAuth_id() {
        return this.auth_id;
    }

    public void setAuth_id(Long auth_id) {
        this.auth_id = auth_id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return this.roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "{" +
            " auth_id='" + getAuth_id() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", roles='" + getRoles() + "'" +
            "}";
    }

}
