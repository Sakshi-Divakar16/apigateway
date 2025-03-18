package com.cinebuzz.offerservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ticketservice", path = "/api/tickets")
public interface TicketServiceClient {
    @GetMapping("/{showId}/availability")
    Boolean areTicketsAvailable(@PathVariable Long showId);
}
