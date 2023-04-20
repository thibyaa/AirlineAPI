package com.example.airline_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name="flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String destination;
    @Column
    private int capacity;
    @Column
    private LocalDate departureDate;
    @Column
    private LocalTime deparutureTime;
    @ManyToMany(mappedBy = "flights")
    @JsonIgnoreProperties({"flights"})
    private List<Passenger> passengers;

    public Flight(String destination, int capacity){
        this.destination = destination;
        this.capacity = capacity;
        this.departureDate = LocalDate.now().plusDays(10);
        this.deparutureTime = LocalTime.now().plusHours(9);
        this.passengers = new ArrayList<>();

    }

//    EMPTY CONSTRUCTOR
    public Flight(){

    }

//    GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDeparutureTime() {
        return deparutureTime;
    }

    public void setDeparutureTime(LocalTime deparutureTime) {
        this.deparutureTime = deparutureTime;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
