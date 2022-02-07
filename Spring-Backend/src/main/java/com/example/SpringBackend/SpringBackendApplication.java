package com.example.SpringBackend;

import java.util.Date;
import java.util.List;

import com.example.SpringBackend.database.entities.*;
import com.example.SpringBackend.database.enums.AuthRole;
import com.example.SpringBackend.database.enums.BillStage;
import com.example.SpringBackend.database.enums.ComplainStage;
import com.example.SpringBackend.database.enums.ResidenceType;
import com.example.SpringBackend.database.enums.WorkerDept;
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
			
			Residences r1 = new Residences(1,"R102",ResidenceType.THREEBHK);
			r1.setTower_ref(t1);
			Residences r2 = new Residences(1,"P102",ResidenceType.TWOBHK);
			r2.setTower_ref(t2);
			Residences r3 = new Residences(1,"E102",ResidenceType.TWOBHK);
			r3.setTower_ref(t3);
			Residences r4 = new Residences(1,"T102",ResidenceType.TWOBHK);
			r4.setTower_ref(t4);
			residenceRepo.saveAll(List.of(r1, r2, r3, r4));
			
			Portfolio p1 = new Portfolio("NORMAL", 10);
			Portfolio p2 = new Portfolio("NORMAL", 10);
			Portfolio p3 = new Portfolio("PRESIDENT", 10);
			Portfolio p4 = new Portfolio("VICE PRESIDENT", 10);

			Auth a1 = new Auth("john@mail.com","1234",AuthRole.RESIDENT);
			Auth a2 = new Auth("jack@mail.com","1234",AuthRole.RESIDENT);
			Auth a3 = new Auth("ahealy@mail.com","1234",AuthRole.RESIDENT);
			Auth a4 = new Auth("mitchS@mail.com","1234",AuthRole.RESIDENT);

			Residents u1 = new Residents("John","+917891234567",p1,List.of(),a1);
			u1.setResidence_ref(r1);
			Residents u2 = new Residents("Jack","+917891234567",p2,List.of(),a2);
			u2.setResidence_ref(r2);
			Residents u3 = new Residents("Healy","+917891234567",p3,List.of(),a3);
			u3.setResidence_ref(r3);
			Residents u4 = new Residents("Mitchell","+917891234567",p4,List.of(),a4);
			u4.setResidence_ref(r4);
			residentRepo.saveAll(List.of(u1, u2, u3, u4));

			Auth a5 = new Auth("supervisor@mail.com","1234",AuthRole.SUPERVISOR);
			Auth a6 = new Auth("manager1@mail.com","1234",AuthRole.MANAGER);
			Auth a7 = new Auth("manager2@mail.com","1234",AuthRole.MANAGER);

			Supervisor s1 = new Supervisor("Supervisor","+917891234567","Address",a5);
			supervisorRepo.save(s1);
			Managers m1 = new Managers("Manager1","+917891234567","Address",a6);
			m1.setTower_ref(t1);
			m1.setSupervisor_ref(s1);
			Managers m2 = new Managers("Manager2","+917891234567","Address",a7);
			m2.setTower_ref(t2);
			m2.setSupervisor_ref(s1);
			managerRepo.saveAll(List.of(m1, m2));

			Watchmen w1 = new Watchmen("Watchman1","+917891234567","Address");
			w1.setManager_ref(m1);
			w1.setTower_ref(t1);
			Watchmen w2 = new Watchmen("Watchman2","+917891234567","Address");
			w2.setManager_ref(m1);
			w2.setTower_ref(t1);
			watchmenRepo.saveAll(List.of(w1, w2));

			Workers w3 = new Workers("Worker1","+917891234567","Address",WorkerDept.SWEEPER);
			w3.setManager_ref(m1);
			w3.setTower_ref(t1);
			Workers w4 = new Workers("Worker2","+917891234567","Address",WorkerDept.SWEEPER);
			w4.setManager_ref(m2);
			w4.setTower_ref(t2);
			workerRepo.saveAll(List.of(w3, w4));

			Bills b1 = new Bills("Maintenance",1200L,BillStage.GENERATED,"");
			b1.setResidence_ref(r1);
			Bills b2 = new Bills("Maintenance",1200L,BillStage.GENERATED,"");
			b2.setResidence_ref(r2);
			Bills b3 = new Bills("Maintenance",1200L,BillStage.GENERATED,"");
			b3.setResidence_ref(r3);
			Bills b4 = new Bills("Maintenance",1200L,BillStage.GENERATED,"");
			b4.setResidence_ref(r4);
			billRepo.saveAll(List.of(b1, b2, b3, b4));

			Complains c1 = new Complains("Complaint1",new Date().toString(),ComplainStage.RAISED);
			c1.setResidence_ref(r1);
			Complains c2 = new Complains("Complaint2",new Date().toString(),ComplainStage.RAISED);
			c2.setResidence_ref(r2);
			complainRepo.saveAll(List.of(c1, c2));

			System.out.println("Command Line Executed");
		};
	}

}
