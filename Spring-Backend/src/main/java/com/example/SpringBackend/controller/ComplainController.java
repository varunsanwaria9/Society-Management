package com.example.SpringBackend.controller;

import com.example.SpringBackend.database.entities.Complains;
import com.example.SpringBackend.database.enums.ComplainStage;
import com.example.SpringBackend.database.models.ComplainModel;
import com.example.SpringBackend.services.ComplainService;
import com.example.SpringBackend.services.ResidentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/complain")
public class ComplainController {
    
    @Autowired
    private ComplainService complainService;
    @Autowired
    private ResidentService residentService;

    @PostMapping(path = "/add")
    public ResponseEntity<Complains> addComplains(@RequestBody ComplainModel model) {
    	Complains complains = new Complains(model.getValue(),new Date().toString(),ComplainStage.RAISED);
        return new ResponseEntity<>(complainService.addComplains(complains),HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Complains> getComplainByID(@PathVariable String id){
        Complains complain = complainService.getComplainByID(id);
        if(complain == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(complain,HttpStatus.OK);
    }

    @GetMapping(path = "/raised/{id}")
    public ResponseEntity<List<Complains>> getResidentComplainsRaised(@PathVariable String id){
        List<Complains> complains = complainService.getResidentComplainRaised(id);
        if (complains.size() == 0) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(complains,HttpStatus.OK);
    }

}
