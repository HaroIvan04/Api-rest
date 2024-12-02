package com.example.haroUDG;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HaroUdgApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaroUdgApplication.class, args);
	}

}
