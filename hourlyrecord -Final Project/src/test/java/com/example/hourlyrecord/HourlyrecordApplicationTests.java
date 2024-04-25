package com.example.hourlyrecord;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hourlyrecord.web.HourlyRecordController;

@SpringBootTest
public class HourlyrecordApplicationTests {

	@Autowired
    private HourlyRecordController HourlyRecordController;
	@Test
	public void contexLoads() throws Exception {
		assertThat(HourlyRecordController).isNotNull();
	}

	

}

