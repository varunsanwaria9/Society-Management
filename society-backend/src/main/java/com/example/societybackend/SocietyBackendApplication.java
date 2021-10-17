package com.example.societybackend;

import com.example.societybackend.databases.entities.Auth;
import com.example.societybackend.databases.entities.Roles;
import com.example.societybackend.databases.entities.Users;
import com.example.societybackend.databases.enums.Role;
import com.example.societybackend.databases.repos.AuthRepo;
import com.example.societybackend.databases.repos.RolesRepo;
import com.example.societybackend.databases.repos.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SocietyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocietyBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepo userRepo, AuthRepo authRepo, RolesRepo rolesRepo){
		return args -> {

			Roles role1 = new Roles(Role.PERSON);
			Roles role2 = new Roles(Role.ADMINISTRATOR);
			Roles role3 = new Roles(Role.MANAGER);
			Roles role4 = new Roles(Role.SUPERVISOR);
			Roles role5 = new Roles(Role.WATCHMAN);
			rolesRepo.saveAll(List.of(role1,role2,role3,role4,role5));

			Users u1 = new Users("Tom","Kat","MALE", LocalDate.now(),"1234567890");
			Auth a1 = new Auth("user1@mail.com","1234", List.of(role1) ,u1);
			authRepo.save(a1);
		};
	}
}
