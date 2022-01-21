package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Issues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepo extends JpaRepository<Issues, Long> {
   
}
