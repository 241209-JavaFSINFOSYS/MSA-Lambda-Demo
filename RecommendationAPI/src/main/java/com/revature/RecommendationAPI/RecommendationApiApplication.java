package com.revature.RecommendationAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@SpringBootApplication
public class RecommendationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecommendationApiApplication.class, args);
	}

	//Our entire functionality will live here now -
	//But I'll leave the controller up for reference

	//Since Lambdas typically deploy APIs with one function...
	//...this is a typical pattern

	//Get Book Recs is going to be a Supplier function
	//Suppliers "supply" data to the requester
	@Bean
	public Supplier<List<String>> getBookRecs(){

		//Realistically, the service would probably be called here

		//return a List of Books
		return () -> List.of("Old Man and Fish", "A Story of Two Towns", "1886");

	}



}
