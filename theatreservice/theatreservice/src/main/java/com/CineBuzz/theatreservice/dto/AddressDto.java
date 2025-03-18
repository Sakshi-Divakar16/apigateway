package com.CineBuzz.theatreservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddressDto {
    private Long addressId;

    @NotBlank(message = "Country cannot be blank")
    private String country;

    @NotBlank(message = "State cannot be blank")
    private String state;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "Address line cannot be blank")
    @Size(min = 5, max = 255, message = "Address must be between 5 and 255 characters")
    private String addressLine;

    public AddressDto() {
    }

    public AddressDto(Long addressId, String country, String state, String city, String addressLine) {
        this.addressId = addressId;
        this.country = country;
        this.state = state;
        this.city = city;
        this.addressLine = addressLine;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
}
