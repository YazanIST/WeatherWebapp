package com.atypon.show_results;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.atypon.show_results"})
public class ShowResultsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowResultsApplication.class, args);
	}

}
