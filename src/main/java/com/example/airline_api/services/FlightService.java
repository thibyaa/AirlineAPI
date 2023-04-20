package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.airline_api.repositories.FlightRepository;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

//    logic: adds a new flight to the repo, returns information of the flight
    public Flight addNewFlight(Flight flight){
       return flightRepository.save(flight);
    }

//    logic: saves the flight to the repo
    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

//    CUSTOM METHODS
    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    public Flight findFlightById(Long id){
        return flightRepository.findById(id).get();
    }
    

}
