package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Parkings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepo extends JpaRepository<Parkings,Integer>{
    
}
