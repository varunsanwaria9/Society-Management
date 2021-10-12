package com.example.societybackend;

import com.example.societybackend.databases.entities.Auth;
import com.example.societybackend.databases.entities.Users;
import com.example.societybackend.databases.repos.AuthRepo;
import com.example.societybackend.databases.repos.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class SocietyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocietyBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepo userRepo, AuthRepo authRepo){
		return args -> {

			Users u1 = new Users("Tom","Kat","MALE", LocalDate.now(),"1234567890");
			Auth a1 = new Auth("user1@mail.com","1234",u1);
			authRepo.save(a1);
		};
	}
}
