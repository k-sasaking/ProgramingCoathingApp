package com.rebelapp.pcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan("com.rebelapp.pcm.entity")
public class ProgramingCoachingMatchingApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProgramingCoachingMatchingApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProgramingCoachingMatchingApplication.class);
    }

}
