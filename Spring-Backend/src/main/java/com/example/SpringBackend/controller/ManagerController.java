package com.example.SpringBackend.controller;

import java.util.List;

import com.example.SpringBackend.database.entities.Managers;
import com.example.SpringBackend.database.entities.Residences;
import com.example.SpringBackend.database.entities.Residents;
import com.example.SpringBackend.services.ManagerService;
import com.example.SpringBackend.services.ResidenceService;
import com.example.SpringBackend.services.ResidentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/manager")
public class ManagerController {
    
    @Autowired
    private ResidenceService residenceService;

    @Autowired
    private ResidentService residentService;

    @Autowired
    private ManagerService managerService;

    @GetMapping("/residences/id/{id}")
    public ResponseEntity<Residences> getResidenceById(@PathVariable String id){
        Residences residences = residenceService.getResidenceById(id);
        if(residences == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(residences, HttpStatus.OK);
    }

    @GetMapping("/residences/tower/{towerId}")
    public ResponseEntity<List<Residences>> getResidencesByTower(@PathVariable int towerId){
        List<Residences> residences = residenceService.getResidencesByTower(towerId);
        if(residences == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(residences, HttpStatus.OK);
    }

    @GetMapping("/residences/flat/{flatNo}")
    public ResponseEntity<Residences> getResidenceByFlatNo(@PathVariable String flatNo){
        Residences residences = residenceService.getResidenceByFlatNo(flatNo);
        if(residences == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(residences, HttpStatus.OK);
    }

    @GetMapping("/residents/tower/{towerId}")
    public ResponseEntity<List<Residents>> getResidentsByTower(@PathVariable int towerId){
        List<Residents> residents = residentService.getAllResidentsByTower(towerId);
        return new ResponseEntity<>(residents, HttpStatus.OK);
    }

    @GetMapping("/profile/get/{id}")
    public ResponseEntity<Managers> getManagerById(@PathVariable String id) throws Exception {
        Managers managers = managerService.getManagerById(id);
        if (managers == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(managers,HttpStatus.OK);
    }

    @PutMapping("/profile/update")
    public ResponseEntity<Managers> updateManagers(@RequestBody Managers managers){
        return new ResponseEntity<>(managerService.updateManagers(managers),HttpStatus.CREATED);
    }

    @GetMapping("/profile/email/{email}")
    public ResponseEntity<Managers> getManagerByEmail(@PathVariable String email) throws Exception {
        try{
            Managers managers = managerService.getManagerByEmail(email);
            return new ResponseEntity<>(managers,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteManagers(@PathVariable String id){
    	managerService.deleteManager(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
}
