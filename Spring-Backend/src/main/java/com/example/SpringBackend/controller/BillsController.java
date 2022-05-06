package com.example.SpringBackend.controller;

import com.example.SpringBackend.database.entities.Bills;
import com.example.SpringBackend.database.models.BillDateModel;
import com.example.SpringBackend.services.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/bills")
public class BillsController {

    @Autowired
    private BillsService billsService;

    @PostMapping("/add")
    public ResponseEntity<Bills> addBills(@RequestBody Bills bills){
        return new ResponseEntity<>(billsService.addBills(bills), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Bills> getBillById(@PathVariable String id){
        Bills bills = billsService.BillsById(id);
        if(bills == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bills,HttpStatus.OK);
    }

    @GetMapping("/generated/{id}")
    public ResponseEntity<List<Bills>> billsByGenerated(@PathVariable String id){
        List<Bills> bills = billsService.BillsResidentGenerated(id);
        if(bills.size() == 0) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bills,HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<Bills>> billsBetnDateResident(@RequestBody BillDateModel billDateModel){
        List<Bills> bills = billsService.BillsBetnDateResidence(billDateModel);
        if (bills.size() == 0) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bills,HttpStatus.OK);
    }

}
