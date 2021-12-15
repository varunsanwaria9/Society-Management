package com.example.societybackend.controller;

import java.util.List;
import java.util.Optional;

import com.example.societybackend.databases.entities.Helpers;
import com.example.societybackend.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/admin")
public class AdminController{


	@Autowired
	private AdminService adminService;

	@GetMapping(path = "/helper/all")
	public ResponseEntity<List<Helpers>> getAllHelpers(){
		return new ResponseEntity<>(adminService.getAllHelpers(),HttpStatus.OK);
	}

	@GetMapping(path = "/helper/id/{id}")
	public ResponseEntity<Helpers> getHelpersById(@PathVariable String id){
		Optional<Helpers> helper = adminService.findHelperById(id);
		if (helper.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(helper.get(),HttpStatus.OK);
	}	

	@PostMapping(path = "/helperAdd")
	public ResponseEntity<Helpers> addHelper(@RequestBody Helpers helper){
		return new ResponseEntity<>(adminService.addHelper(helper),HttpStatus.CREATED);
	}
}
