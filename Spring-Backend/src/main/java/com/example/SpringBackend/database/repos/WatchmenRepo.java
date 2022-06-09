package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Watchmen;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WatchmenRepo extends JpaRepository<Watchmen, String> {

	@Query(value = "select * from watchmen where tower_ref = ?1",nativeQuery = true)
	List<Watchmen> getWatchmenByTower(String towerRef);
}
