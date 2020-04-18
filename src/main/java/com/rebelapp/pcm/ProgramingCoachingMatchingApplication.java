package com.rebelapp.pcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.rebelapp.pcm.entity")
public class ProgramingCoachingMatchingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramingCoachingMatchingApplication.class, args);
	}

}
