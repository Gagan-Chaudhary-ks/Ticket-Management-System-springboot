package com.gagan.ticketmanagementsystem.service;

import com.gagan.ticketmanagementsystem.entity.User;
import com.gagan.ticketmanagementsystem.entity.Ticket;
import com.gagan.ticketmanagementsystem.repository.TicketRepository;
import com.gagan.ticketmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private TicketRepository ticketRepository ;

    public Ticket createTicket(Ticket ticket, Integer creatorId, Integer assignedToId){

        User creator = userRepository.findById(creatorId)
                .orElseThrow(() -> new RuntimeException("User with ID " + creatorId + " not found"));
        ticket.setCreatedBy(creator);

        if(assignedToId != null){
            User resolver = userRepository.findById(assignedToId)
                    .orElseThrow(() -> new RuntimeException("User with ID " + assignedToId+ " not found"));
            ticket.setAssignedTo(resolver);
        }
        return ticketRepository.save(ticket);
    }
}
