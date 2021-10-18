package com.example.societybackend.databases.repos;

import com.example.societybackend.databases.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {
}
