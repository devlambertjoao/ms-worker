package com.lambert.eurekaserver.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.lambert.eurekaserver.*")
public class MsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEurekaServerApplication.class, args);
	}

}
