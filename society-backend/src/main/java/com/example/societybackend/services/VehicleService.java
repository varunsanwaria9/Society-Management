package com.example.societybackend.services;

import java.util.List;
import java.util.Optional;

import com.example.societybackend.databases.entities.Vehicle;
import com.example.societybackend.databases.repos.VehicleRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepo vehicleRepo;

	public Vehicle addVehicle(Vehicle vehicle){
		return vehicleRepo.save(vehicle);
	}

	public List<Vehicle> allVehicles(){
		return vehicleRepo.findAll();
	}

	public Optional<Vehicle> findVehicleById(String id){
		return vehicleRepo.findById(id);
	}
}
