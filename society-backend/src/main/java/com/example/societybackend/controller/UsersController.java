package com.example.societybackend.controller;

import com.example.societybackend.databases.entities.Auth;
import com.example.societybackend.databases.entities.Roles;
import com.example.societybackend.databases.entities.Users;
import com.example.societybackend.databases.repos.AuthRepo;
import com.example.societybackend.databases.repos.RolesRepo;
import com.example.societybackend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private AuthRepo authRepo;

    @GetMapping(path = "/allUsers")
    public List<Users> allUsers(){
        return usersService.allUsers();
    }

    @GetMapping(path = "/roles")
    public ResponseEntity<List<Auth>> allRoles() {
        return new ResponseEntity<>(authRepo.findAll(), HttpStatus.OK);
    }

}
