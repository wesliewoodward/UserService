package com.hcl.microservices.user2.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
	
	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String userPassword = "userpassword";
		String encodedUserPassword = encoder.encode(userPassword);
		
		System.out.println("User password: " + encodedUserPassword);
		
		String adminPassword = "adminpassword";
		String encodedAdminPassword = encoder.encode(adminPassword);
		
		System.out.println("\n\nAdmin password: " + encodedAdminPassword);
		
	}

}
