package com.upgrad.VehicleBookingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class VehicleBookingCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleBookingCircuitBreakerApplication.class, args);
	}
}
