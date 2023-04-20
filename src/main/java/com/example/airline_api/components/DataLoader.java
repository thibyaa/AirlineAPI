package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;

public class DataLoader {

    @Autowired
    PassengerService passengerService;

    @Autowired
    FlightService flightService;

    public DataLoader(){

    }
    public void run(ApplicationArguments args) throws Exception {
        Flight hawaiiFlight = new Flight("Hawaii", 200, "16.06.23", "12:00");
        Flight japanFlight = new Flight("Japan", 250, "31.05.23", "13:00");
        Passenger Anna = new Passenger("Anna", "anna@bnta.com");
        Passenger Zsolt = new Passenger("Zsolt", "zsolt@bnta.com");
        flightService.saveFlight(hawaiiFlight);
        flightService.saveFlight(japanFlight);
        passengerService.savePassenger(Anna);
        passengerService.savePassenger(Zsolt);
    }
}
