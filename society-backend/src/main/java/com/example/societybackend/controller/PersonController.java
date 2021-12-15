package com.example.societybackend.controller;

import com.example.societybackend.databases.entities.*;
import com.example.societybackend.databases.repos.AuthRepo;
import com.example.societybackend.services.PersonService;
import com.example.societybackend.services.VehicleService;

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
	@Autowired
	private VehicleService vehicleService;

    @GetMapping(path = "/allUsers")
    public ResponseEntity<List<Person>> allUsers(){
        return new ResponseEntity<>(personService.allUsers(),HttpStatus.OK);
    }

	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Optional<Person>> personById(@PathVariable String id){
		return new ResponseEntity<>(personService.getById(id),HttpStatus.OK);
	}

	@GetMapping(path = "/myVehicle/{id}")
	public ResponseEntity<List<Vehicle>> personAllVehicle(@PathVariable String id){
		Optional<Person> person = personService.getById(id);
		if (person.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		return new ResponseEntity<>(person.get().getVehicles(),HttpStatus.OK);
	}

	@PostMapping(path = "/addVehicle/{id}")
	public ResponseEntity<Person> addPersonVehicle(@RequestBody Vehicle vehicle,@PathVariable String id){
		Optional<Person> person = personService.getById(id);	
		if(person.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		Vehicle savedVehicle = vehicleService.addVehicle(vehicle);
		List<Vehicle> currVehicle = person.get().getVehicles();
		currVehicle.add(savedVehicle);
		person.get().setVehicles(currVehicle);
		return new ResponseEntity<>(personService.updatePerson(person.get()),HttpStatus.OK);
	}
}


