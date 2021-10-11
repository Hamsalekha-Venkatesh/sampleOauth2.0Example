package com.hamsa.CoronaVirusStats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronaVirusStatsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoronaVirusStatsApplication.class, args);
	}

}
