package com.cinebuzz.seatservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SeatDto {

    private Long seatId;

    @NotNull(message = "Tier ID cannot be null")
    private Long tierId;

    @NotBlank(message = "Seat number is required")
    private String seatNumber;

    @NotBlank(message = "Status is required")
    private String status; // e.g., AVAILABLE, BOOKED, BLOCKED

    public SeatDto() {}

    public SeatDto(Long seatId, Long tierId, String seatNumber, String status) {
        this.seatId = seatId;
        this.tierId = tierId;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public Long getTierId() {
        return tierId;
    }

    public void setTierId(Long tierId) {
        this.tierId = tierId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
