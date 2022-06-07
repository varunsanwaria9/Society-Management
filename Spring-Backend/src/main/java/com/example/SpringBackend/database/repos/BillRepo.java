package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Bills;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepo extends JpaRepository<Bills,String>{

    @Query(value = "select b.* from bills b where b.residence_ref = ?1  and b.status = 'GENERATED'",nativeQuery = true)
    List<Bills> billsByResidenceGenerated(String id);

    @Query(value = "select * from bills where (generated_on between ?1 and ?2) and residence_ref = ?3",nativeQuery = true)
    List<Bills> billsByBetnDatesResidence(String startDate,String endDate,String id);

    @Query(value= "select * from bills where status='GENERATED'",nativeQuery = true)
    List<Bills> allGeneratedBills();
    
}