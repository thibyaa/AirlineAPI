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

//    public Passenger addPassengerToFlight(Passenger passenger, Long flightId){
////        find flight by id
//        Flight flight = flightRepository.findById(flightId).get();
////        set passengers flight to flight id
//        passenger.addToFlight(flight);
////        save passenger
//        return passengerRepository.save(passenger);
//    }

    public Passenger addPassengerToFlight(Passenger passenger, Long flightId){
        Flight flight = flightRepository.findById(flightId).get();
        if(flight.getCapacity() < flight.getCapacity()){
            passenger.addToFlight(flight);
//            else statement?? to maybe inform passenger
//            that the flight is full????
        }
        return passengerRepository.save(passenger);
    }
}
