package com.example.airline_api.services;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.airline_api.repositories.PassengerRepository;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    FlightRepository flightRepository;
    public void savePassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }

//    CUSTOM METHODS
    public Passenger addNewPassenger(Passenger passenger){
       return passengerRepository.save(passenger);
    }

    public List<Passenger> findAllPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id){
        return passengerRepository.findById(id).get();
    }

    public Passenger addPassengerToFlight(Passenger passenger, Long flightId){
//        find flight by id
//        set passengers flight to flight id
//        save passenger
        Flight flight = flightRepository.findById(flightId).get();
        passenger.addToFlight(flight);
        return passengerRepository.save(passenger);
    }
}
