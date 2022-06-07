package com.example.SpringBackend.services;

import com.example.SpringBackend.database.entities.Bills;
import com.example.SpringBackend.database.entities.Residences;
import com.example.SpringBackend.database.entities.Residents;
import com.example.SpringBackend.database.models.BillDateModel;
import com.example.SpringBackend.database.repos.BillRepo;
import com.example.SpringBackend.database.repos.ResidenceRepo;
import com.example.SpringBackend.database.repos.ResidentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillsService {

    @Autowired
    private BillRepo billRepo;
    @Autowired
    private ResidentRepo residentRepo;

    public Bills addBills(Bills bill){
        return billRepo.save(bill);
    }

    public Bills BillsById(String id){
        Optional<Bills> bills = billRepo.findById(id);
        return bills.orElse(null);
    }

    public List<Bills> BillsResidentGenerated(String id){
        Optional<Residents> residents = residentRepo.findById(id);
        if(residents.isEmpty()) return List.of();
        return billRepo.billsByResidenceGenerated(residents.get().getResidence_ref().getResidence_id());
    }

    public List<Bills> BillsBetnDateResidence(BillDateModel billDateModel){
        Optional<Residents> residents = residentRepo.findById(billDateModel.getResidence_ref());
        if(residents.isEmpty()) return List.of();
        return billRepo.billsByBetnDatesResidence(billDateModel.getStartDate(), billDateModel.getEndDate(), residents.get().getResidence_ref().getResidence_id());
     }

    public List<Bills> allGeneratedBills(){
    	return billRepo.allGeneratedBills();
    }
}
