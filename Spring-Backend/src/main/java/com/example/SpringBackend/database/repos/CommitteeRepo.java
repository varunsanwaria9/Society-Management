package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Committee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitteeRepo extends JpaRepository<Committee, Long> {
   
}
