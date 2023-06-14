package com.inventory.invmgtsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@SpringBootApplication
//public class InvmgtsysApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(InvmgtsysApplication.class, args);
//	}
//
//}

@SpringBootApplication
public class InvmgtsysApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InvmgtsysApplication.class);
	}



	public static void main(String[] args) {
		SpringApplication.run(InvmgtsysApplication.class, args);
	}
}
