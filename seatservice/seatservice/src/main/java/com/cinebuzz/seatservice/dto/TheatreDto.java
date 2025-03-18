package com.cinebuzz.seatservice.dto;

public class TheatreDto {
    private Long theatreId;
    private String theatreName;
    private int capacity;
    private int screens;
    private AddressDto address;

    public TheatreDto() {
    }

    public TheatreDto(Long theatreId, String theatreName, int capacity, int screen, AddressDto address) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.capacity = capacity;
        this.screens = screen;
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

    public int getScreen() {
        return screens;
    }

    public void setScreen(int screen) {
        this.screens = screen;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
