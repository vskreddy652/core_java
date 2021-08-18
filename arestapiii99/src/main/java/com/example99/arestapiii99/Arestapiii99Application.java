package com.example99.arestapiii99;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example99.arestapiii99",
	"com.example99.*"})
public class Arestapiii99Application {

	public static void main(String[] args) {
		SpringApplication.run(Arestapiii99Application.class, args);
	}

}
