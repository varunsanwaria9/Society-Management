package com.example.SpringBackend.controller;

import com.example.SpringBackend.database.entities.Bills;
import com.example.SpringBackend.database.entities.Residences;
import com.example.SpringBackend.database.enums.BillStage;
import com.example.SpringBackend.database.models.BillAddModel;
import com.example.SpringBackend.database.models.BillDateModel;
import com.example.SpringBackend.services.BillsService;
import com.example.SpringBackend.services.ResidenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/bills")
public class BillsController {

    @Autowired
    private BillsService billsService;
    @Autowired
    private ResidenceService residenceService;


    @PostMapping("/add")
    public ResponseEntity<Bills> addBills(@RequestBody BillAddModel model){
    	Bills bills = new Bills(model.getDetails(),model.getAmount(),BillStage.GENERATED,LocalDate.now().toString(),"");
    	Residences residences = residenceService.getResidenceByFlatNo(model.getFlat_no());
    	if(residences == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	bills.setResidence_ref(residences);
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

    @GetMapping("/generated")
    public ResponseEntity<List<Bills>> allGeneratedBill(){
    	return new ResponseEntity<>(billsService.allGeneratedBills(),HttpStatus.OK);
    }
    
    @PutMapping("/paid/{id}")
    public ResponseEntity<Bills> makeBillsPaid(@PathVariable String id){
    	Bills bill = billsService.makeBillPaid(id);
    	if(bill == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	return new ResponseEntity<>(bill,HttpStatus.CREATED);
    }
}
