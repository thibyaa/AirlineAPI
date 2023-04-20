package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.airline_api.services.FlightService;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

//    TODO: ADD DETAILS OF A NEW FLIGHT
//    CREATE
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        return new ResponseEntity<>(flightService.addNewFlight(flight), HttpStatus.CREATED);
    }

//    TODO: DISPLAY ALL AVAILABLE FLIGHTS
//    INDEX
    @GetMapping
    public ResponseEntity<List<Flight>> seeAllFlight(){
        return new ResponseEntity<>(flightService.findAllFlights(), HttpStatus.OK);
    }

//    TODO: DISPLAY DETAILS OF A SPECIFIC FLIGHT
//    SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Flight> showSpecificFlight(@PathVariable Long id){
        return new ResponseEntity<>(flightService.findFlightById(id), HttpStatus.OK);
    }

//    TODO: CANCEL A FLIGHT
//    DESTROY
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Long> deleteFlight(@PathVariable Long id){
        flightService.removeFlight(id);
        return new ResponseEntity<>(id, HttpStatus.ACCEPTED);
    }
}
