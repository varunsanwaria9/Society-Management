package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Watchmen;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchmenRepo extends JpaRepository<Watchmen, String> {

    
}
