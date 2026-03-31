package com.gagan.ticketmanagementsystem.repository;

import com.gagan.ticketmanagementsystem.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository <Ticket,Integer> {
}
