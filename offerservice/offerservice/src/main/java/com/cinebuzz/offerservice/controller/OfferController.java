package com.cinebuzz.offerservice.controller;

import com.cinebuzz.offerservice.dto.OfferDto;
import com.cinebuzz.offerservice.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping
    public ResponseEntity<OfferDto> createOffer(@RequestBody OfferDto offerDto) {
        return ResponseEntity.ok(offerService.createOffer(offerDto));
    }

    @GetMapping("/{offerId}")
    public ResponseEntity<OfferDto> getOfferById(@PathVariable Long offerId) {
        return ResponseEntity.ok(offerService.getOfferById(offerId));
    }

    @GetMapping
    public ResponseEntity<List<OfferDto>> getAllOffers() {
        return ResponseEntity.ok(offerService.getAllOffers());
    }

    @PutMapping("/{offerId}")
    public ResponseEntity<OfferDto> updateOffer(@PathVariable Long offerId, @RequestBody OfferDto offerDto) {
        return ResponseEntity.ok(offerService.updateOffer(offerId, offerDto));
    }

    @DeleteMapping("/{offerId}")
    public ResponseEntity<Void> deleteOffer(@PathVariable Long offerId) {
        offerService.deleteOffer(offerId);
        return ResponseEntity.noContent().build();
    }
}
