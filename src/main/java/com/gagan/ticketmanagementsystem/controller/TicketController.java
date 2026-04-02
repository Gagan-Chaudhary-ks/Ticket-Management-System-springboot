package com.gagan.ticketmanagementsystem.controller;

import com.gagan.ticketmanagementsystem.entity.Ticket;
import com.gagan.ticketmanagementsystem.dto.TicketRequestDTO;
import com.gagan.ticketmanagementsystem.repository.TicketRepository;
import com.gagan.ticketmanagementsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gagan.ticketmanagementsystem.dto.TicketUpdateDTO;

import java.util.List;


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

    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> tickets = ticketService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Integer id){
        Ticket ticket = ticketService.getTicketById(id);
        return new ResponseEntity<>(ticket ,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Integer id, @RequestBody TicketUpdateDTO updateDto){
        Ticket updatedTicket = ticketService.updateTicket(id, updateDto);
        return new ResponseEntity<>(updatedTicket,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteTicket(@PathVariable Integer id){
        ticketService.softDeleteTicket(id);
        return new ResponseEntity<>("Ticket deleted successfully",HttpStatus.OK);
    }
}
