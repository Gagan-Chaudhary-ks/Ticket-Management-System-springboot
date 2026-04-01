package com.gagan.ticketmanagementsystem.controller;

import com.gagan.ticketmanagementsystem.entity.Ticket;
import com.gagan.ticketmanagementsystem.dto.TicketRequestDTO;
import com.gagan.ticketmanagementsystem.repository.TicketRepository;
import com.gagan.ticketmanagementsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketRequestDTO ticketRequestDTO){
        Ticket createdTicket = ticketService.createTicket(ticketRequestDTO);
        return new ResponseEntity<Ticket>(createdTicket, HttpStatus.CREATED);
    }
}
