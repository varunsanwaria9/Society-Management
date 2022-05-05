package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Portfolio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepo extends JpaRepository<Portfolio, String> {
   
}
