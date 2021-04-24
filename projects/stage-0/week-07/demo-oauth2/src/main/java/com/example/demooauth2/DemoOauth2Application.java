package com.example.demooauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class DemoOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoOauth2Application.class, args);
	}

	@GetMapping("/hello")
	public String hello(Principal principal) {
		return String.format("Hell %s!", principal.getName());
	}


}
