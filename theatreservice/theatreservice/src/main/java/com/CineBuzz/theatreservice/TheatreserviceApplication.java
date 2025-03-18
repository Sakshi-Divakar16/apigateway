package com.CineBuzz.theatreservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TheatreserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheatreserviceApplication.class, args);
		System.out.println("Theatre service started on port number 8080");
	}

}
