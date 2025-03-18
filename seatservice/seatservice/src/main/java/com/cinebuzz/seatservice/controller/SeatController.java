package com.cinebuzz.seatservice.controller;

import com.cinebuzz.seatservice.dto.SeatDto;
import com.cinebuzz.seatservice.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping
    public ResponseEntity<SeatDto> createSeat(@RequestBody SeatDto seatDto) {
        return ResponseEntity.ok(seatService.createSeat(seatDto));
    }

    @GetMapping("/{seatId}")
    public ResponseEntity<SeatDto> getSeatById(@PathVariable Long seatId) {
        return ResponseEntity.ok(seatService.getSeatById(seatId));
    }

    @GetMapping
    public ResponseEntity<List<SeatDto>> getAllSeats() {
        return ResponseEntity.ok(seatService.getAllSeats());
    }

    @PutMapping("/{seatId}")
    public ResponseEntity<SeatDto> updateSeat(@PathVariable Long seatId, @RequestBody SeatDto seatDto) {
        return ResponseEntity.ok(seatService.updateSeat(seatId, seatDto));
    }

    @DeleteMapping("/{seatId}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long seatId) {
        seatService.deleteSeat(seatId);
        return ResponseEntity.noContent().build();
    }

    // ✅ New Endpoint: Reserve a Seat
    @PutMapping("/{seatId}/reserve")
    public ResponseEntity<String> reserveSeat(@PathVariable Long seatId) {
        seatService.reserveSeat(seatId);
        return ResponseEntity.ok("Seat reserved successfully");
    }
}
