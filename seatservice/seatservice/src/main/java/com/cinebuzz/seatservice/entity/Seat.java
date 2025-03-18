package com.cinebuzz.seatservice.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "seats", uniqueConstraints = @UniqueConstraint(columnNames = {"tier_id", "seat_number"}))
public class Seat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @ManyToOne
    @JoinColumn(name = "tier_id", nullable = false)
    private Tier tier;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(nullable = false)
    private String status; // e.g., AVAILABLE, BOOKED, BLOCKED

    public Seat() {}

    public Seat(Tier tier, String seatNumber, String status) {
        this.tier = tier;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
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
