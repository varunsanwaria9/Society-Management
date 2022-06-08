package com.example.SpringBackend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBackend.database.repos.WatchmenRepo;
import com.example.SpringBackend.database.repos.WorkerRepo;
import com.example.SpringBackend.database.entities.*;

@Service
public class StaffService {

	@Autowired
	private WatchmenRepo watchmenRepo;
	@Autowired
	private WorkerRepo workerRepo;
	
	
	public Watchmen addWatchmen(Watchmen watchmen) {
		return watchmenRepo.save(watchmen);
	}
	
	public Workers addWorkers(Workers workers) {
		return workerRepo.save(workers);
	}
	
	public List<Watchmen> getAllWatchmen(){
		return watchmenRepo.findAll();
	}
	
	public List<Workers> getAllWorkers(){
		return workerRepo.findAll();
	}
	
	public Watchmen getWatchmenById(String id) {
		Optional<Watchmen> watchmen = watchmenRepo.findById(id);
		return watchmen.orElse(null);
	}
	
	public Workers getWorkersById(String id) {
		Optional<Workers> workers = workerRepo.findById(id);
		return workers.orElse(null);
	}
	
	public Watchmen updateWatchmen(Watchmen watchmen) {
		return watchmenRepo.save(watchmen);
	}
	
	public Workers updateWorkers(Workers workers) {
		return workerRepo.save(workers);
	}
	
	public void deleteWatchmen(String id) {
		watchmenRepo.deleteById(id);
	}
	
	public void deleteWorkers(String id) {
		workerRepo.deleteById(id);
	}
	
}
