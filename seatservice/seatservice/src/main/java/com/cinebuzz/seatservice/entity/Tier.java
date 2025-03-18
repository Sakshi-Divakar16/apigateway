package com.cinebuzz.seatservice.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tier", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"tier_name", "theatre_id"}) // Ensures unique tier names per theatre
})
public class Tier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tierId;

    @Column(name = "tier_name", nullable = false)
    private String tierName; // VIP, STANDARD, ECONOMY

    @Column(nullable = false)
    private Long theatreId; // Foreign key from Theatre Service

    @Column(nullable = false)
    private double ticketPriceMultiplier; // Price multiplier for ticket pricing

    @OneToMany(mappedBy = "tier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats;

    public Tier() {}

    public Tier(String tierName, Long theatreId, double ticketPriceMultiplier) {
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
