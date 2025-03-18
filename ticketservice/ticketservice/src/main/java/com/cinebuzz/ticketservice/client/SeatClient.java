package com.cinebuzz.ticketservice.client;

import com.cinebuzz.ticketservice.dto.SeatDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "seatservice", path = "/api/seats")
public interface SeatClient {

    @GetMapping("/{seatId}")
    SeatDto getSeatById(@PathVariable Long seatId);

    @PutMapping("/{seatId}/reserve")
    String reserveSeat(@PathVariable Long seatId);
}
