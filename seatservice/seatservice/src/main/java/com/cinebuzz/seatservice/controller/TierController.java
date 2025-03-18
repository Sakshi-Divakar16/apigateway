package com.cinebuzz.seatservice.controller;

import com.cinebuzz.seatservice.dto.TierDto;
import com.cinebuzz.seatservice.service.TierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiers")
public class TierController {

    @Autowired
    private TierService tierService;

    @PostMapping
    public ResponseEntity<TierDto> createTier(@Valid @RequestBody TierDto tierDto) {
        return ResponseEntity.ok(tierService.createTier(tierDto));
    }

    @GetMapping("/{tierId}")
    public ResponseEntity<TierDto> getTierById(@PathVariable Long tierId) {
        return ResponseEntity.ok(tierService.getTierById(tierId));
    }

    @GetMapping
    public ResponseEntity<List<TierDto>> getAllTiers() {
        return ResponseEntity.ok(tierService.getAllTiers());
    }

    @PutMapping("/{tierId}")
    public ResponseEntity<TierDto> updateTier(@PathVariable Long tierId, @RequestBody TierDto tierDto) {
        return ResponseEntity.ok(tierService.updateTier(tierId, tierDto));
    }

    @DeleteMapping("/{tierId}")
    public ResponseEntity<Void> deleteTier(@PathVariable Long tierId) {
        tierService.deleteTier(tierId);
        return ResponseEntity.noContent().build();
    }
}
