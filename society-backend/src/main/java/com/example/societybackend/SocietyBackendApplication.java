package com.example.societybackend;

import com.example.societybackend.databases.entities.*;
import com.example.societybackend.databases.enums.VehicleType;
import com.example.societybackend.databases.repos.AuthRepo;
import com.example.societybackend.databases.repos.PersonRepo;
import com.example.societybackend.databases.repos.RolesRepo;
import com.example.societybackend.databases.repos.VehicleRepo;
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
	CommandLineRunner runner(PersonRepo personRepo,
							 AuthRepo authRepo,
							 RolesRepo rolesRepo,
							 VehicleRepo vehicleRepo,
							 PasswordEncoder passwordEncoder){
		return args -> {

			Roles role1 = new Roles("PERSON");
			Roles role2 = new Roles("ADMINISTRATOR");
			Roles role3 = new Roles("MANAGER");
			Roles role4 = new Roles("SUPERVISOR");
			Roles role5 = new Roles("WATCHMAN");
			rolesRepo.saveAll(List.of(role1,role2,role3,role4,role5));

			Vehicle v1p1 = vehicleRepo.save(new Vehicle("XY 82 1921", VehicleType.TWOWHEELER));
			Auth ap1 = new Auth("user1@mail.com", passwordEncoder.encode("1234"), List.of(role1));
//			authRepo.save(ap1);
			Person p1 = new Person("Tom","Jerry","MALE","12920398234",
					"21/08/2002","X21", List.of(v1p1), ap1);
			personRepo.save(p1);
		};
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
