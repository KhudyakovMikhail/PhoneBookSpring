package ru.academits.khudyakov.phonebookspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PhoneBookSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(PhoneBookSpringApplication.class, args);
	}
}
