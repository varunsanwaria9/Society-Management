package com.example.SpringBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBackend.database.entities.Watchmen;
import com.example.SpringBackend.database.entities.Workers;
import com.example.SpringBackend.services.StaffService;

@RestController
@CrossOrigin
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@GetMapping("/watchmen/all")
	public ResponseEntity<List<Watchmen>> getAllWatchmen(){
		return new ResponseEntity<>(staffService.getAllWatchmen(),HttpStatus.OK);
	}
	
	@PostMapping("/watchmen/add")
	public ResponseEntity<Watchmen> addWatchmen(@RequestBody Watchmen watchmen){
		return new ResponseEntity<>(staffService.addWatchmen(watchmen),HttpStatus.CREATED);
	}
	
	@GetMapping("/watchmen/get/{id}")
	public ResponseEntity<Watchmen> watchmenById(@PathVariable String id){
		Watchmen watchmen = staffService.getWatchmenById(id);
		if(watchmen == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(staffService.getWatchmenById(id),HttpStatus.OK);
	}
	
	@PutMapping("/watchmen/update")
	public ResponseEntity<Watchmen> updateWatchmen(@RequestBody Watchmen watchmen){
		return new ResponseEntity<>(staffService.updateWatchmen(watchmen),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/watchmen/delete/{id}")
	public ResponseEntity<?> deleteWatchmen(@PathVariable String id){
		staffService.deleteWatchmen(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/worker/add")
	public ResponseEntity<Workers> addWorkers(@RequestBody Workers workers){
		return new ResponseEntity<>(staffService.addWorkers(workers),HttpStatus.CREATED);
	}
	
	@GetMapping("/worker/all")
	public ResponseEntity<List<Workers>> getAllWorkers(){
		return new ResponseEntity<>(staffService.getAllWorkers(),HttpStatus.OK);
	}
	
	@GetMapping("/worker/get/{id}")
	public ResponseEntity<Workers> getWorkersById(@PathVariable String id){
		Workers worker = staffService.getWorkersById(id);
		return new ResponseEntity<>(worker,HttpStatus.OK);
	}
	
	@PutMapping("/worker/update")
	public ResponseEntity<Workers> updateWorker(@RequestBody Workers workers){
		return new ResponseEntity<>(staffService.updateWorkers(workers),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/worker/delete/{id}")
	public ResponseEntity<?> deleteWorkers(@PathVariable String id){
		staffService.deleteWorkers(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
