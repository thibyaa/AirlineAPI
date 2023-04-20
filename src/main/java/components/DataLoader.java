package components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import services.FlightService;
import services.PassengerService;

public class DataLoader {

    @Autowired
    PassengerService passengerService;

    @Autowired
    FlightService flightService;

    public DataLoader(){

    }
    public void run(ApplicationArguments args) throws Exception {

    }
}
