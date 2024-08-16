package com.rtarcisio.olympicgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OlympicGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlympicGatewayApplication.class, args);
	}

}
