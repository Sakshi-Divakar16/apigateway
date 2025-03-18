package com.cinebuzz.seatservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TierDto {

    private Long tierId;

    @NotBlank(message = "Tier name is required")
    private String tierName;

    @NotNull(message = "Theatre ID cannot be null")
    private Long theatreId;

    @NotNull(message = "Ticket price multiplier cannot be null")
    private double ticketPriceMultiplier;

    public TierDto() {}

    public TierDto(Long tierId, String tierName, Long theatreId, double ticketPriceMultiplier) {
        this.tierId = tierId;
        this.tierName = tierName;
        this.theatreId = theatreId;
        this.ticketPriceMultiplier = ticketPriceMultiplier;
    }

    public Long getTierId() {
        return tierId;
    }

    public void setTierId(Long tierId) {
        this.tierId = tierId;
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public double getTicketPriceMultiplier() {
        return ticketPriceMultiplier;
    }

    public void setTicketPriceMultiplier(double ticketPriceMultiplier) {
        this.ticketPriceMultiplier = ticketPriceMultiplier;
    }
}
