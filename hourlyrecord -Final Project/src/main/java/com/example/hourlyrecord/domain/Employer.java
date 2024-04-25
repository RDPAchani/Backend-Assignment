package com.example.hourlyrecord.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employer")
    private List<HourlyRecord> hourlyRecords;

    public Employer() {
    }

    public Employer(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HourlyRecord> getHourlyRecords() {
        return hourlyRecords;
    }

    public void setHourlyRecords(List<HourlyRecord> hourlyRecords) {
        this.hourlyRecords = hourlyRecords;
    }

}
