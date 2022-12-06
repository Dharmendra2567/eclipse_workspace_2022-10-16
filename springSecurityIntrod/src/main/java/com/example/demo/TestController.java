package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("")
	public String Home() {
		return "<h1>home page</h1>";
	}
	@RequestMapping("/user")
	public String user() {
		return "<h1>User's page</h1>";
	}
	@RequestMapping("/admin")
	public String Admin() {
		return "<h1>Admin's page</h1>";
	}
}
