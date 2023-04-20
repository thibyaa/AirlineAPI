package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PassengerService passengerService;

    @Autowired
    FlightService flightService;


    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Flight hawaiiFlight = new Flight("Hawaii", 200, "16.06.23", "12:00");
        Flight japanFlight = new Flight("Japan", 250, "31.05.23", "13:00");
        Passenger anna = new Passenger("Anna", "anna@bnta.com");
        Passenger zsolt = new Passenger("Zsolt", "zsolt@bnta.com");
        flightService.saveFlight(hawaiiFlight);
        flightService.saveFlight(japanFlight);
        anna.addToFlight(hawaiiFlight);
        zsolt.addToFlight(japanFlight);
        passengerService.savePassenger(anna);
        passengerService.savePassenger(zsolt);
    }
}
