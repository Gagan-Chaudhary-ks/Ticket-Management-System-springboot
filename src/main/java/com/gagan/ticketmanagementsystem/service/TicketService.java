package com.gagan.ticketmanagementsystem.service;

import com.gagan.ticketmanagementsystem.dto.TicketRequestDTO;
import com.gagan.ticketmanagementsystem.entity.User;
import com.gagan.ticketmanagementsystem.entity.Ticket;
import com.gagan.ticketmanagementsystem.repository.TicketRepository;
import com.gagan.ticketmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private TicketRepository ticketRepository ;

    public Ticket createTicket(TicketRequestDTO ticketDto){
        Ticket ticket = new Ticket();

        ticket.setTitle(ticketDto.getTitle());
        ticket.setDescription(ticketDto.getDescription());

        User creator = userRepository.findById(ticketDto.getCreatorId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"User with ID "+ ticketDto.getCreatorId() + " not found! "));
        ticket.setCreatedBy(creator);

        if(ticketDto.getAssignedToId() != null){
            User assignedTo = userRepository.findById(ticketDto.getAssignedToId())
                    .orElseThrow(()-> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,"User with ID " + ticketDto.getAssignedToId()+ " not found!"));
            ticket.setAssignedTo(assignedTo);
        }
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
}
