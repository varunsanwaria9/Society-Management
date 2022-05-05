package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Bills;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bills,String>{
    
}
