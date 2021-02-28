package com.lambert.worker.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.lambert.worker.*" })
public class MsWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsWorkerApplication.class, args);
	}

}
