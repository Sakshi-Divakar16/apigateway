package com.CineBuzz.theatreservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "theatres")
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreId;

    private String theatreName;
    private int capacity;
    private int screens;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    public Theatre() {
    }

    public Theatre(Long theatreId, String theatreName, int capacity, int screens, Address address) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.capacity = capacity;
        this.screens = screens;
        this.address = address;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getScreens() {
        return screens;
    }

    public void setScreens(int screens) {
        this.screens = screens;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
