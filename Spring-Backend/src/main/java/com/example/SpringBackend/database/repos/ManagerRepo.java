package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Managers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Managers, Long> {
   
}
