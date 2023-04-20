package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.airline_api.repositories.FlightRepository;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerService passengerService;

//    logic: saves the flight to the repo
    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

//    CUSTOM METHODS
//    logic: adds a new flight to the repo, returns information of the flight
    public Flight addNewFlight(Flight flight){
        return flightRepository.save(flight);
    }

    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    public Flight findFlightById(Long id){
        return flightRepository.findById(id).get();
    }

    public void removeFlight(Long flightId){
//        Get the flight
        Flight flight = flightRepository.findById(flightId).get();
//        Loop through the passengers that are on the flight and remove flight
        for(Passenger passenger: flight.getPassengers()){
            passenger.removeFromFlight(flight);
            passengerService.savePassenger(passenger);
        }
        flightRepository.deleteById(flightId);
    }
}
