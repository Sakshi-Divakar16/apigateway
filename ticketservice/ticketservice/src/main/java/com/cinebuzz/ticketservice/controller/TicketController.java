package com.cinebuzz.ticketservice.controller;

import com.cinebuzz.ticketservice.dto.TicketDto;
import com.cinebuzz.ticketservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDto> bookTicket(@RequestBody TicketDto ticketDto) {
        TicketDto bookedTicket = ticketService.bookTicket(ticketDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookedTicket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable Long id) {
        TicketDto ticket = ticketService.getTicketById(id);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping
    public ResponseEntity<List<TicketDto>> getAllTickets() {
        List<TicketDto> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelTicket(@PathVariable Long id) {
        ticketService.cancelTicket(id);
        return ResponseEntity.ok("Ticket with ID " + id + " has been successfully canceled.");
    }

    @GetMapping("/{showId}/availability")
    public ResponseEntity<Boolean> areTicketsAvailable(@PathVariable Long showId) {
        return ResponseEntity.ok(ticketService.areTicketsAvailable(showId));
    }
}
