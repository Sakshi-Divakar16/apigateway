package com.cinebuzz.ticketservice.service;

import com.cinebuzz.ticketservice.dto.TicketDto;
import java.util.List;

public interface TicketService {
    TicketDto bookTicket(TicketDto ticketDto);
    TicketDto getTicketById(Long ticketId);
    List<TicketDto> getAllTickets();
    void cancelTicket(Long ticketId);
    boolean areTicketsAvailable(Long showId);

}
