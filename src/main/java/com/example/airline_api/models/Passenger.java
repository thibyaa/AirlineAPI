package com.example.airline_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name="email_address")
    private String emailAddress;

    @JsonIgnoreProperties({"passengers"})
    @ManyToMany
    @JoinTable(
            name = "passengers_flights",
            joinColumns = @JoinColumn(name="passenger_id"),
            inverseJoinColumns = @JoinColumn(name="flight_id")
    )
    private List<Flight> flights;
    public Passenger(String name, String emailAddress){
        this.name = name;
        this.emailAddress = emailAddress;
        this.flights = new ArrayList<>();
    }

//    EMPTY CONSTRUCTOR
    public Passenger(){

    }

//    GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }


//    METHODS ASSOCIATED WITH MANY TO MANY
    public void addToFlight(Flight flight){
        this.flights.add(flight);
    }

    public void removeFromFlight(Flight flight){
        this.flights.remove(flight);
    }
}
