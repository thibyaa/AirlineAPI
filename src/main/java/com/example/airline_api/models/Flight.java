package com.example.airline_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String destination;
    @Column
    private int capacity;
    @Column(name="departure_date")
    private String departureDate;
    @Column(name="departure_time")
    private String deparutureTime;
    @ManyToMany(mappedBy = "flights")
    @JsonIgnoreProperties({"flights"})
    private List<Passenger> passengers;

    public Flight(String destination, int capacity, String departureDate, String deparutureTime){
        this.destination = destination;
        this.capacity = capacity;
        this.departureDate = departureDate;
        this.deparutureTime = deparutureTime;
        this.passengers = new ArrayList<>();

    }

//    EMPTY CONSTRUCTOR
    public Flight(){

    }

//    GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDeparutureTime() {
        return deparutureTime;
    }

    public void setDeparutureTime(String deparutureTime) {
        this.deparutureTime = deparutureTime;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
