package com.example.airline_api.controllers;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

//    TODO: ADD A NEW PASSENGER
//    CREATE
    @PostMapping
    public ResponseEntity<Passenger> addNewPassenger(Passenger passenger){
        Passenger npassenger = passengerService.addNewPassenger(passenger);
        return new ResponseEntity<>(npassenger, HttpStatus.CREATED);
    }

//    TODO: DISPLAY DETAILS OF ALL PASSENGERS
//    INDEX
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.findAllPassengers(), HttpStatus.OK);
    }

//    TODO: DISPLAY DETAILS OF SPECIFIC PASSENGERS
//    SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id){
        return new ResponseEntity<>(passengerService.getPassengerById(id), HttpStatus.OK);
    }

//    TODO: BOOK A PASSENGER ON TO A FLIGHT
//    UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Passenger> addPassengerToFlight(@PathVariable Long id, @RequestParam Long flightId){
        Passenger passenger = passengerService.getPassengerById(id);
        return new ResponseEntity<>(passengerService.addPassengerToFlight(passenger, flightId), HttpStatus.OK);
    }
}
