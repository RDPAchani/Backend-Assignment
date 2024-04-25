package com.example.hourlyrecord;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.hourlyrecord.domain.AppUser;
import com.example.hourlyrecord.domain.AppUserRepository;
import com.example.hourlyrecord.domain.HourlyRecord;
import com.example.hourlyrecord.domain.HourlyRecordRepository;
import com.example.hourlyrecord.domain.EmployerRepository;
import com.example.hourlyrecord.domain.Employer;
import com.example.hourlyrecord.HourlyrecordApplication;

@SpringBootTest(classes = HourlyrecordApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HourlyRecordRepositoryTest {

    @Autowired
    private HourlyRecordRepository repository;

    @Autowired
    private EmployerRepository crepository;
    
    @Test
    public void findByDescriptionShouldReturnDescription() {
        List<HourlyRecord> hourlyrecords = repository.findByDescription("workshift");
        
        //test one hourly record is found
        assertThat(hourlyrecords).hasSize(1);

        //check the date of the found hourly record
        assertThat(hourlyrecords.get(0).getDate()).isEqualTo("2024-04-25");
    }
    
    //Test create and save function
    @Test
    public void createNewHourlyRecord() {
    	Employer employer = new Employer("Subway");
    	crepository.save(employer);
    	HourlyRecord hourlyrecord = new HourlyRecord("2024-04-28", "15:00", "20:00", "Training", employer);
    	repository.save(hourlyrecord);

        //test that houlrly record has an id
    	assertThat(hourlyrecord.getId()).isNotNull();
    }    

    // find hourly record by description
    @Test
    public void deleteNewHourlyRecord() {
		List<HourlyRecord> hourlyrecords = repository.findByDescription("Training");
		HourlyRecord hourlyrecord = hourlyrecords.get(0);

        // test delete
		repository.delete(hourlyrecord);
		List<HourlyRecord> newHourlyRecord = repository.findByDescription("workshift");
		assertThat(newHourlyRecord).hasSize(0);
     }

     @Test

     public void testCalculateHoursWorked(){
       
       String startTime="08:00";
       String endTime="12:30";

       
        HourlyRecord hourlyRecord = new HourlyRecord("2024-04-25", startTime, endTime, "Workshift", null);

        // Calculate hours worked
        double hoursWorked = hourlyRecord.calculateHoursWorked();

        // Expected result: 4.5 hours (12:30 - 8:00 = 4.5 hours)
        double expectedHours = 4.5;

        // test that the calculated hours match the expected result
        assertEquals(expectedHours, hoursWorked, 0.01); 


     }

}
