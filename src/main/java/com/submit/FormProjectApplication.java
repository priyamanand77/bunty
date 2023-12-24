package com.submit;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class FormProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormProjectApplication.class, args);
	}
	
	  @PostConstruct
	    public void init(){
	      // Setting Spring Boot SetTimeZone
	      TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	    }

}
