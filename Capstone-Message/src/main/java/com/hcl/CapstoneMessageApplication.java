package com.hcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CapstoneMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneMessageApplication.class, args);
	}

}
