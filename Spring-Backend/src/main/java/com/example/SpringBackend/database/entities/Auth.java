package com.example.SpringBackend.database.entities;

import javax.persistence.*;

import com.example.SpringBackend.database.enums.AuthRole;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Auth {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String auth_id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AuthRole roles;


    public Auth() {
    }

    public Auth(String email, String password, AuthRole roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    
    public Auth(String auth_id, String email, String password, AuthRole roles) {
        this.auth_id = auth_id;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    

    public String getAuth_id() {
        return this.auth_id;
    }

    public void setAuth_id(String auth_id) {
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

    public AuthRole getRoles() {
        return this.roles;
    }

    public void setRoles(AuthRole roles) {
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
