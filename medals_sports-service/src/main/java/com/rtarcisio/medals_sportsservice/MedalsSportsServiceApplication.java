package com.rtarcisio.medals_sportsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MedalsSportsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedalsSportsServiceApplication.class, args);
	}

}
