package com.example.hourlyrecord;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.hourlyrecord.domain.AppUser;
import com.example.hourlyrecord.domain.AppUserRepository;
import com.example.hourlyrecord.domain.Employer;
import com.example.hourlyrecord.domain.EmployerRepository;
import com.example.hourlyrecord.domain.HourlyRecord;
import com.example.hourlyrecord.domain.HourlyRecordRepository;

@SpringBootApplication
public class HourlyrecordApplication {
	private static final Logger log = LoggerFactory.getLogger(HourlyrecordApplication.class);

public static void main(String[] args) {
		SpringApplication.run(HourlyrecordApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstoreDemo(HourlyRecordRepository repository, EmployerRepository crepository, AppUserRepository urepository) {
		return (args) -> {

// Create employers( currently i am working at these resturants)
			Employer employer1 = new Employer("Burger King");
			Employer employer2 = new Employer("Subway");
		
	// save employers to the repository		
			crepository.save(employer1);
			crepository.save(employer2);
			
			// create and save some hourly records initially
			log.info("save worked hours");
			repository.save(new HourlyRecord("2024-04-25", "08:00", "12:00", "Workshift", employer1));
			repository.save(new HourlyRecord("2024-04-26", "10:00", "17:00", "Training", employer2));	
			
			//create users

			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","ADMIN");

			//save users to the repository
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all workshifts");
			for (HourlyRecord hourlyRecord : repository.findAll()) {
				log.info(hourlyRecord.toString());
			}

			// retrieve and log hourly records by description
			log.info("Find by Description");
			for (HourlyRecord hourlyRecord : repository.findByDescription("workshift")) {
				log.info(hourlyRecord.toString());
			}


		};
	}


}

