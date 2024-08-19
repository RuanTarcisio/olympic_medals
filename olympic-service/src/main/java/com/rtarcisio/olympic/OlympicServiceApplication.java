package com.rtarcisio.olympic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OlympicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlympicServiceApplication.class, args);
	}

}
