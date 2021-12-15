package com.example.societybackend.services;

import java.util.List;
import java.util.Optional;

import com.example.societybackend.databases.entities.Helpers;
import com.example.societybackend.databases.repos.HelperRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService{

	@Autowired
	private HelperRepo helperRepo;

	public Helpers addHelper(Helpers helper){
		return helperRepo.save(helper);
	}

	public List<Helpers> getAllHelpers(){
		return helperRepo.findAll();
	}
	
	public Optional<Helpers> findHelperById(String id){
		return helperRepo.findById(id);
	}
}
