package com.example.SpringBackend.controller;

import com.example.SpringBackend.database.entities.Notice;
import com.example.SpringBackend.database.entities.Residents;
import com.example.SpringBackend.database.repos.NoticeRepo;
import com.example.SpringBackend.services.ResidentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents")
@CrossOrigin
public class ResidentController {
    
    @Autowired
    private ResidentService residentService;
    @Autowired
    private NoticeRepo noticeRepo;
    
    
    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<Residents> findByEmail(@PathVariable String email) {
        return new ResponseEntity<>(residentService.findByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<Residents> findDetailsById(@PathVariable String id){
        return new ResponseEntity<>(residentService.getResidentsById(id),HttpStatus.OK);
    }

    @PutMapping("/updateProfile")
    public ResponseEntity<Residents> updateResidents(@RequestBody Residents residents){
        return new ResponseEntity<>(residentService.updateResidents(residents), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteResidents(@PathVariable String id){
    	residentService.deleteResidents(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/notice/all")
    public ResponseEntity<List<Notice>> getAllNotices(){
    	return new ResponseEntity<>(noticeRepo.findAll(),HttpStatus.OK);
    }
    
}
