package com.example.SpringBackend.controller;

import com.example.SpringBackend.database.entities.Managers;
import com.example.SpringBackend.database.entities.Notice;
import com.example.SpringBackend.database.entities.Residents;
import com.example.SpringBackend.database.entities.Supervisor;
import com.example.SpringBackend.database.repos.NoticeRepo;
import com.example.SpringBackend.services.ManagerService;
import com.example.SpringBackend.services.ResidentService;
import com.example.SpringBackend.services.SupervisorService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/supervisor")
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private ResidentService residentService;
    @Autowired
    private NoticeRepo noticeRepo;
    
    @GetMapping("/profile/get/{id}")
    public ResponseEntity<Supervisor> getSupervisorById(@PathVariable String id){
        Supervisor supervisor = supervisorService.getSupervisorById(id);
        if(supervisor == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(supervisor,HttpStatus.OK);
    }

    @GetMapping("/profile/email/{email}")
    public ResponseEntity<Supervisor> getSupervisorByEmail(@PathVariable String email){
        Supervisor supervisor = supervisorService.getSupervisorByEmail(email);
        if (supervisor == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(supervisor,HttpStatus.OK);
    }

    @PutMapping("/profile/update/supervisor")
    public ResponseEntity<Supervisor> updateSupervisorProfile(@RequestBody Supervisor supervisor){
        return new ResponseEntity<>(supervisorService.updateSupervisor(supervisor),HttpStatus.CREATED);
    }
    
    @GetMapping("/managers/all")
    public ResponseEntity<List<Managers>> getAllManagers(){
    	return new ResponseEntity<>(managerService.getAllManagers(),HttpStatus.OK);
    }
    
    @GetMapping("/resident/search/{search}")
    public ResponseEntity<List<Residents>> searchResidents(@PathVariable String search){
    	return new ResponseEntity<>(residentService.searchResidents(search),HttpStatus.OK);
    }
    
    @GetMapping("/notice/all")
    public ResponseEntity<List<Notice>> getAllNotices(){
    	return new ResponseEntity<>(noticeRepo.findAll(),HttpStatus.OK);
    }
    
    @GetMapping("/notice/id/{id}")
    public ResponseEntity<Notice> getNoticeById(@PathVariable String id){
    	Optional<Notice> notice = noticeRepo.findById(id);
    	if(notice.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	return new ResponseEntity<>(notice.get(),HttpStatus.OK);
    }
    
    @DeleteMapping("/notice/delete/{id}")
    public ResponseEntity<?> deleteNotice(@PathVariable String id){
    	noticeRepo.deleteById(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/notice/add")
    public ResponseEntity<Notice> addNotice(@RequestBody Notice notice){
    	return new ResponseEntity<>(noticeRepo.save(notice),HttpStatus.CREATED);
    }
}
