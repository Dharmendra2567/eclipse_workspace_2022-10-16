package com.example.demo;

import java.util.Base64;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePassword {
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("password"));
	}

}
