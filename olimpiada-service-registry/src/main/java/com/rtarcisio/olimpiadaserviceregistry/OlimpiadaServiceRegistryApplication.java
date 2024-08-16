package com.rtarcisio.olimpiadaserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class OlimpiadaServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlimpiadaServiceRegistryApplication.class, args);
	}

}
