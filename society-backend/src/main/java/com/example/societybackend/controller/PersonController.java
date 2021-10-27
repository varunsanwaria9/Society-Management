package com.example.societybackend.controller;

import com.example.societybackend.databases.entities.*;
import com.example.societybackend.databases.repos.AuthRepo;
import com.example.societybackend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Optional<Person>> personById(@PathVariable String id){
		return new ResponseEntity<>(personService.getById(id),HttpStatus.OK);
	}

	@PutMapping(path = "/addVehicle/{id}")
	public ResponseEntity<Person> addVehicle(@RequestBody Vehicle vehicle,@PathVariable String id){
		Person person = personService.getById(id).get();
		List<Vehicle> vehicles = person.getVehicles();
		vehicles.add(vehicle);
		return new ResponseEntity<>(person,HttpStatus.OK);
	}
}


