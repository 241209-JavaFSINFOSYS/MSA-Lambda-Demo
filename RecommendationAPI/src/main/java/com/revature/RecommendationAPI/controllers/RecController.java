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

    /* Ok... why bother using a completely different app for Book recommendations?
    In this case, I just wanted to show an MSA working and they could have coexisted, but...

     An MSA benefits us by allowing us to have multiple services that can be scaled independently
     This allows us to have a more flexible, fault-tolerant, loosely-coupled, and higher-performance app

     A monolithic app (which we've been using) can be difficult to scale and they're more prone to system-wide failure
     If one service fails in an MSA, the other services can still function (maybe with reduced functionality)

    MSAs are more complex to develop and maintain, but they can be way more flexible/powerful in the long run
    Look into MSA components like service discovery, load balancing, circuit breakers, and API gateway */

    @GetMapping
    public ResponseEntity<String[]> getBookRecs(){

        String[] books = {"The Very Hungry Caterpillar", "Frog and Toad", "Where the Sidewalk Ends",
         "1984", "The Body", "The Old Man and the Sea"};

        return ResponseEntity.ok(books);

    }

}
