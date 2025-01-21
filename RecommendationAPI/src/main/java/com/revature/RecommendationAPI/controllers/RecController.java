package com.revature.RecommendationAPI.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recs")
@CrossOrigin
public class RecController {

    @GetMapping
    public ResponseEntity<String[]> getBookRecs(){

        String[] books = {"The Very Hungry Caterpillar", "Frog and Toad", "Where the Sidewalk Ends",
         "1984", "The Body", "The Old Man and the Sea"};

        return ResponseEntity.ok(books);

    }

}
