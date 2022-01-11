package com.example.SpringBackend;

import java.util.List;

import com.example.SpringBackend.database.entities.Towers;
import com.example.SpringBackend.database.repos.TowerRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(TowerRepo towerRepo){
		return args -> {
			Towers t1 = new Towers("Ruby");
			Towers t2 = new Towers("Pearl");
			Towers t3 = new Towers("Emerald");
			Towers t4 = new Towers("Topaz");
			Towers t5 = new Towers("Sapphire");
			Towers t6 = new Towers("Club House");
			Towers t7 = new Towers("Security");
			Towers t8 = new Towers("Main Gate");
			Towers t9 = new Towers("Swimming Pool");
			Towers t10 = new Towers("Gym");
			towerRepo.saveAll(List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));
		
			System.out.println("Command Line Executed");
		};
	}

}
