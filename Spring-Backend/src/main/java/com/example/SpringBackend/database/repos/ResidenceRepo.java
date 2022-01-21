package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Residences;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidenceRepo extends JpaRepository<Residences, Integer> {

}
