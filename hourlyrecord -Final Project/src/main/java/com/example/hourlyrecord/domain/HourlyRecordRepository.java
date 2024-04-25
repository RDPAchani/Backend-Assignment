package com.example.hourlyrecord.domain;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HourlyRecordRepository extends CrudRepository<HourlyRecord,Long>{
    List<HourlyRecord> findByDescription(String description);
   
// calulate total hours

default double calulateTotalHours() {
    List<HourlyRecord> allRecords = (List<HourlyRecord>) findAll();
    double totalHours = 0.0;
    //iterate through all hourly records and sum up the hours worked
    for (HourlyRecord record : allRecords) {
        totalHours += record.calculateHoursWorked();
    }
    return totalHours;
}

}

