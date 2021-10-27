package com.example.societybackend;

import com.example.societybackend.databases.entities.*;
import com.example.societybackend.databases.enums.VehicleType;
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

			Roles role1 = new Roles("PERSON");
			Roles role2 = new Roles("ADMINISTRATOR");
			Roles role3 = new Roles("MANAGER");
			Roles role4 = new Roles("SUPERVISOR");
			Roles role5 = new Roles("WATCHMAN");
			rolesRepo.saveAll(List.of(role1,role2,role3,role4,role5));

			Vehicle v1p1 = new Vehicle("XX 21 AZ 2131", VehicleType.FOURWHEELER);
			Auth a1 = new Auth("user1@mail.com",passwordEncoder.encode("1234"),List.of(role1));
//			authRepo.save(a1);
			Person p = new Person("Tom","Kat","MALE","20/2/2003","12092382","B201",List.of(v1p1),a1);
			personRepo.save(p);
		};
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
