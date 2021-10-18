package com.example.societybackend.controller;

import com.example.societybackend.databases.entities.Auth;
import com.example.societybackend.databases.entities.Person;
import com.example.societybackend.databases.entities.Users;
import com.example.societybackend.databases.repos.AuthRepo;
import com.example.societybackend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/persons")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private AuthRepo authRepo;

    @GetMapping(path = "/allUsers")
    public List<Person> allUsers(){
        return personService.allUsers();
    }

    @GetMapping(path = "/roles")
    public ResponseEntity<List<Auth>> allRoles() {
        return new ResponseEntity<>(authRepo.findAll(), HttpStatus.OK);
    }

}
