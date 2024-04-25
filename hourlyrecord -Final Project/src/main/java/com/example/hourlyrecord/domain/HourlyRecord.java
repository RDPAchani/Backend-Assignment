package com.example.hourlyrecord.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;

@Entity
public class HourlyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    public HourlyRecord() {
    }

    public HourlyRecord(String date, String startTime, String endTime, String description, Employer employer) {
        this.date = LocalDate.parse(date);
        this.startTime = LocalTime.parse(startTime);
        this.endTime = LocalTime.parse(endTime);
        this.description = description;
        this.employer = employer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    //Method to calulate the hours worked 

    public double calculateHoursWorked(){
        // calculate duration between start and end time
        Duration duration = Duration.between(startTime, endTime);

        // convert duration to hours
        return duration.toMinutes() / 60.0;
    }

}
