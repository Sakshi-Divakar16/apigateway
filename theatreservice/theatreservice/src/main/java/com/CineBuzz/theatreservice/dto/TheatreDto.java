package com.CineBuzz.theatreservice.dto;


import jakarta.validation.constraints.*;

public class TheatreDto {
    private Long theatreId;

    @NotBlank(message = "Theatre name cannot be blank")
    @Size(min = 3, max = 100, message = "Theatre name must be between 3 and 100 characters")
    private String theatreName;

    @Min(value = 50, message = "Capacity must be at least 50 seats")
    @Max(value = 5000, message = "Capacity cannot exceed 5000 seats")
    private int capacity;

    @Min(value = 1, message = "Screen number must be at least 1")
    private int screens;

    @NotNull( message = "Address is required")
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
