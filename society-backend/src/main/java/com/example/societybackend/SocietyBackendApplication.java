package com.example.societybackend;

import com.example.societybackend.databases.entities.Auth;
import com.example.societybackend.databases.entities.Person;
import com.example.societybackend.databases.entities.Roles;
import com.example.societybackend.databases.entities.Users;
import com.example.societybackend.databases.enums.Role;
import com.example.societybackend.databases.repos.AuthRepo;
import com.example.societybackend.databases.repos.PersonRepo;
import com.example.societybackend.databases.repos.RolesRepo;
import com.example.societybackend.databases.repos.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SocietyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocietyBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepo userRepo,
							 PersonRepo personRepo,
							 AuthRepo authRepo,
							 RolesRepo rolesRepo,
							 PasswordEncoder passwordEncoder){
		return args -> {

			Roles role1 = new Roles(Role.PERSON);
			Roles role2 = new Roles(Role.ADMINISTRATOR);
			Roles role3 = new Roles(Role.MANAGER);
			Roles role4 = new Roles(Role.SUPERVISOR);
			Roles role5 = new Roles(Role.WATCHMAN);
			rolesRepo.saveAll(List.of(role1,role2,role3,role4,role5));

			Person u1 = new Person("Tom","Kat","MALE", LocalDate.now(),"1234567890","B203");
			Auth a1 = new Auth("user1@mail.com", passwordEncoder.encode("1234"), List.of(role1) ,u1);
			authRepo.save(a1);

			Person u2 = new Person("Tom","Kat","MALE", LocalDate.now(),"1234567890","C302");
			Auth a2 = new Auth("user2@mail.com", passwordEncoder.encode("1234"), List.of(role5) ,u2);
			authRepo.save(a2);
		};
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
