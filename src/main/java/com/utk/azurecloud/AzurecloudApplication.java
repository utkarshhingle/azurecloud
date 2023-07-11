package com.utk.azurecloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AzurecloudApplication {

	@GetMapping("/message")
	public String message() {
		return "Congratulation your app deployed successfully on Azure ";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AzurecloudApplication.class, args);
	}

}
