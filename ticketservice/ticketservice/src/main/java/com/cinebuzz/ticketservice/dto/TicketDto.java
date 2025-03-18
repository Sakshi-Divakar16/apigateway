package com.cinebuzz.ticketservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketDto {

    private Long ticketId;
    private Long showId;
    private Long seatId;
    private BigDecimal amount;
    private LocalDateTime purchaseDate;
    private String status;

    public TicketDto() {}

    public TicketDto(Long ticketId, Long showId, Long seatId, BigDecimal amount, LocalDateTime purchaseDate, String status) {
        this.ticketId = ticketId;
        this.showId = showId;
        this.seatId = seatId;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.status = status;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
