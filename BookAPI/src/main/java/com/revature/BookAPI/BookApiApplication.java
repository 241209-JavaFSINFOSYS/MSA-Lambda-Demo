package com.revature.BookAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Supplier;

@SpringBootApplication
public class BookApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApiApplication.class, args);
	}

	//Again, I'm leaving the Controller for reference
	//But a lambda will typically go main bean -> service

	//Another supplier function that sends the users own books back
	@Bean
	public Supplier<List<String>> getBooks(){

		return () -> List.of("People of Paper", "The Alchemist", "The Lean Startup");

	}

}
