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
			ResidentRepo residentRepo,
			AuthRepo authRepo,
			SupervisorRepo supervisorRepo,
			ManagerRepo managerRepo,
			WatchmenRepo watchmenRepo,
			WorkerRepo workerRepo,
			BillRepo billRepo,
			ComplainRepo complainRepo,
			PortfolioRepo portfolioRepo) {
		
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
			
			Residences r1 = new Residences(1,102,"3BHK",t1.getTower_id());
			Residences r2 = new Residences(1,102,"2BHK",t2.getTower_id());
			Residences r3 = new Residences(1,102,"2BHK",t3.getTower_id());
			Residences r4 = new Residences(1,102,"3BHK",t4.getTower_id());
			residenceRepo.saveAll(List.of(r1, r2, r3, r4));
			
			Portfolio p1 = new Portfolio("NORMAL", 10);
			Portfolio p2 = new Portfolio("NORMAL", 10);
			Portfolio p3 = new Portfolio("PRESIDENT", 10);
			Portfolio p4 = new Portfolio("VICE PRESIDENT", 10);
			portfolioRepo.saveAll(List.of(p1, p2, p3, p4));

			Auth a1 = new Auth("john@mail.com","1234","RESIDENT");
			Auth a2 = new Auth("jack@mail.com","1234","RESIDENT");
			Auth a3 = new Auth("ahealy@mail.com","1234","RESIDENT");
			Auth a4 = new Auth("mitchS@mail.com","1234","RESIDENT");

			Residents u1 = new Residents("John","+917891234567",r1.getResidence_id(),p1.getPortfolio_id(),List.of(),a1);
			Residents u2 = new Residents("Jack","+917891234567",r2.getResidence_id(),p2.getPortfolio_id(),List.of(),a2);
			Residents u3 = new Residents("Healy","+917891234567",r3.getResidence_id(),p3.getPortfolio_id(),List.of(),a3);
			Residents u4 = new Residents("Mitchell","+917891234567",r4.getResidence_id(),p4.getPortfolio_id(),List.of(),a4);
			residentRepo.saveAll(List.of(u1, u2, u3, u4));

			Auth a5 = new Auth("supervisor@mail.com","1234","SUPERVISOR");
			Auth a6 = new Auth("manager1@mail.com","1234","MANAGER");
			Auth a7 = new Auth("manager2@mail.com","1234","MANAGER");

			Supervisor s1 = new Supervisor("Supervisor","+917891234567","Address",a5);
			supervisorRepo.save(s1);
			Managers m1 = new Managers("Manager1","+917891234567","Address",t1.getTower_id(),s1.getSupervisor_id(),a6);
			Managers m2 = new Managers("Manager2","+917891234567","Address",t2.getTower_id(),s1.getSupervisor_id(),a7);
			managerRepo.saveAll(List.of(m1, m2));

			Watchmen w1 = new Watchmen("Watchman1","+917891234567","Address",m1.getManager_id(),t1.getTower_id());
			Watchmen w2 = new Watchmen("Watchman2","+917891234567","Address",m2.getManager_id(),t2.getTower_id());
			watchmenRepo.saveAll(List.of(w1, w2));

			Workers w3 = new Workers("Worker1","+917891234567","Address","SWEEPER",m1.getManager_id(),t1.getTower_id());
			Workers w4 = new Workers("Worker2","+917891234567","Address","SWEEPER",m2.getManager_id(),t2.getTower_id());
			workerRepo.saveAll(List.of(w3, w4));

			Bills b1 = new Bills("Maintenance",1200L,"GENERATED","",r1.getResidence_id());
			Bills b2 = new Bills("Maintenance",1200L,"GENERATED","",r2.getResidence_id());
			Bills b3 = new Bills("Maintenance",1200L,"GENERATED","",r3.getResidence_id());
			Bills b4 = new Bills("Maintenance",1200L,"GENERATED","",r4.getResidence_id());
			billRepo.saveAll(List.of(b1, b2, b3, b4));

			Complains c1 = new Complains("Complaint1",new Date().toString(),"RAISED",r1.getResidence_id());
			Complains c2 = new Complains("Complaint2",new Date().toString(),"RAISED",r2.getResidence_id());
			complainRepo.saveAll(List.of(c1, c2));

			System.out.println("Command Line Executed");
		};
	}

}
