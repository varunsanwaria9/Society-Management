package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Towers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TowerRepo extends JpaRepository<Towers, String> {

}
 
