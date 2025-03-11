package com.revature.InsertBookAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class InsertBookApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsertBookApiApplication.class, args);
	}

	//This time, we'll use a Function type function
	//"Function" is a functional interface that takes one argument and returns a result

	@Bean
	public Function<String, String> insertBook(){
		return (input) -> {
			return "Book " + input + " has been inserted!";
		};
	}

}
