package com.cinebuzz.offerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OfferserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfferserviceApplication.class, args);
		System.out.println("Offer server started on port number 8086");
	}

}
