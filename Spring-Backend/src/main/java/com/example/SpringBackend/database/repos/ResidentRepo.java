package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Residents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepo extends JpaRepository<Residents, Long> {
   
}
