package com.revature.BookAPI.controllers;

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

    //Method that doesn't interact with any other API
    @GetMapping
    public ResponseEntity<String[]> getAllBooks(){

        String[] books = {"People of Paper", "The Alchemist", "The Lean Startup",
        "Das Kapital", "Masters of Rome", "Kite Runner", "Flowers for Algernon"};

        return ResponseEntity.ok(books);

    }

    //Method that uses RestTemplate to consume another API in this MSA
    @GetMapping("/recs")
    public ResponseEntity<String[]> getBookRecs(){

        RestTemplate restTemplate = new RestTemplate();

        String[] recs = restTemplate.getForObject("http://localhost:8081/recs", String[].class);

        return ResponseEntity.ok(recs);

    }

}
