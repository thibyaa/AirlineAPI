package com.example.airline_api.services;
import com.example.airline_api.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.airline_api.repositories.PassengerRepository;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;
    public void savePassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }
}
