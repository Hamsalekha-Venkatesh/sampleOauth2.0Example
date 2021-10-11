package com.hamsa.hystrixdashboard;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@SpringBootApplication
public class HystrixDashboardApplication  {

	private String appTitle;

	public HystrixDashboardApplication(@Value("${my.properties}")  String appTitle) {
		this.appTitle = appTitle;
		System.out.println(appTitle);
	}

	public static void main(String [] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}

}
