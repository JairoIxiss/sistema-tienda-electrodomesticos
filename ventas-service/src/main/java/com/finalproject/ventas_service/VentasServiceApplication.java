package com.finalproject.ventas_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class VentasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VentasServiceApplication.class, args);
	}

}