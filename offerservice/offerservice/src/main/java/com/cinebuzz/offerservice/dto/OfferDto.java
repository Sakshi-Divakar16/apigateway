package com.cinebuzz.offerservice.dto;

import java.math.BigDecimal;

public class OfferDto {
    private Long offerId;
    private Long showId;
    private String offerDetails;
    private BigDecimal discountPercentage;

    public OfferDto() {}

    public OfferDto(Long offerId, Long showId, String offerDetails, BigDecimal discountPercentage) {
        this.offerId = offerId;
        this.showId = showId;
        this.offerDetails = offerDetails;
        this.discountPercentage = discountPercentage;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public String getOfferDetails() {
        return offerDetails;
    }

    public void setOfferDetails(String offerDetails) {
        this.offerDetails = offerDetails;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
