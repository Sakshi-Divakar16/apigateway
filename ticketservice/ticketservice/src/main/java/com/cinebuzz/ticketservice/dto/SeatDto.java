package com.cinebuzz.ticketservice.dto;

public class SeatDto {

    private Long seatId;
    private Long tierId;
    private String seatNumber;
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
