package com.cinebuzz.ticketservice.repository;

import com.cinebuzz.ticketservice.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    long countByShowIdAndStatus(Long showId, String status);
}

