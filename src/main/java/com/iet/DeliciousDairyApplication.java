package com.iet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DeliciousDairyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliciousDairyApplication.class, args);
		
		System.out.println("\n \t \t Hello Welcome To CDAC IET Acts \n \t \t \t  Developed By Team Delicious_Dairy....");
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}



}
