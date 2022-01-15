package com.example.SpringBackend;

import java.util.Date;
import java.util.List;

import com.example.SpringBackend.database.entities.*;
import com.example.SpringBackend.database.repos.*;

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
	CommandLineRunner runner(TowerRepo towerRepo,
			ResidenceRepo residenceRepo,
			ParkingRepo parkingRepo,
			UserRepo userRepo,
			IssueRepo issueRepo,
			AuthRepo authRepo,
			Society_AuthRepo society_AuthRepo) {
		
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
			
			Parkings p1 = new Parkings("R1","KA-01-HH-1234","FOURWHEELER",t1.getTower_id());
			Parkings p2 = new Parkings("T2","KA-01-HH-9999","FOURWHEELER",t4.getTower_id());
			Parkings p3 = new Parkings("E3","KA-01-HH-7777","TWOWHEELER",t3.getTower_id());
			parkingRepo.saveAll(List.of(p1, p2, p3));

			Residences r1 = new Residences(1,102,t1.getTower_id(),List.of(p1));
			Residences r2 = new Residences(1,102,t2.getTower_id(),List.of());
			Residences r3 = new Residences(1,102,t3.getTower_id(),List.of(p3));
			Residences r4 = new Residences(1,102,t4.getTower_id(),List.of(p2));
			residenceRepo.saveAll(List.of(r1, r2, r3, r4));

			Auth a1 = new Auth("john@mail.com","1234","RESIDENT");
			Auth a2 = new Auth("jack@mail.com","1234","RESIDENT");
			Auth a3 = new Auth("ahealy@mail.com","1234","RESIDENT");
			Auth a4 = new Auth("mitchS@mail.com","1234","RESIDENT");
			authRepo.saveAll(List.of(a1, a2, a3, a4));

			Users u1 = new Users("John", "Doe", "MALE","483284293",r1.getResidence_id(),a1.getAuth_id());
			Users u2 = new Users("Jack","Willow","MALE","38423945",r3.getResidence_id(),a2.getAuth_id());
			Users u3 = new Users("Alyssa","Healy","FEMALE","4290348230",r4.getResidence_id(),a3.getAuth_id());
			Users u4 = new Users("Mitchell","Starc","MALE","4523948212",r4.getResidence_id(),a4.getAuth_id());
			userRepo.saveAll(List.of(u1,u2,u3,u4));

			Issues issue1 = new Issues("Smell from drainage system",new Date().toString(),u1.getId(),"Solved");
			Issues issue2 = new Issues("Smell from drainage system",new Date().toString(),u2.getId(),"Resolving");
			Issues issue3 = new Issues("No proper waste pickup from house",new Date().toString(),u2.getId(),"Generated");
			issueRepo.saveAll(List.of(issue1,issue2,issue3));

			Society_Auth sa1 = new Society_Auth();
			Society_Auth sa2 = new Society_Auth();
			society_AuthRepo.saveAll(List.of(sa1,sa2));

			System.out.println("Command Line Executed");
		};
	}

}
