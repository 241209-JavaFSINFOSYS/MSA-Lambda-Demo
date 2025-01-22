package com.revature.BookAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {

    //We need this Object to create circuit breakers in our methods
    @Autowired
    private CircuitBreakerFactory<?, ?> circuitBreakerFactory;

    //Method that doesn't interact with any other API
    @GetMapping
    public ResponseEntity<String[]> getAllBooks(){

        String[] books = {"People of Paper", "The Alchemist", "The Lean Startup",
        "Das Kapital", "Masters of Rome", "Kite Runner", "Flowers for Algernon"};

        return ResponseEntity.ok(books);

    }

    /*This method utilizes a CIRCUIT BREAKER

    Circuit Breakers are good for error handling but it goes deeper than that
    Let's say the Recommendation API is down. This failure would cascade down to the Book API if left unhandled
    Circuit Breakers let us define fallback functionality and prevent access to the failing service until it's fixed */

    //Method that uses RestTemplate to consume another API in this MSA
    @GetMapping("/recs")
    public ResponseEntity<?> getBookRecs(){

        //Create a ciruit breaker and define a fallback functionality

        return circuitBreakerFactory.create("recsAPI").run(
                () -> {
                    RestTemplate restTemplate = new RestTemplate();
                    String[] recs = restTemplate.getForObject("http://localhost:8081/recs", String[].class);
                    return ResponseEntity.ok(recs);
                },
                throwable -> getRecsFallback(throwable)
        );
    }

    //Fallback method for getBookRecs
    public ResponseEntity<?> getRecsFallback(Throwable t){
        System.out.println("Fallback method called due to: " + t.getMessage());
        return ResponseEntity.ok("Sorry, couldn't get Recommendations right now. Please try again later.");
    }

}