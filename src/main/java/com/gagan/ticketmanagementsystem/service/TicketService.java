package com.gagan.ticketmanagementsystem.service;

import com.gagan.ticketmanagementsystem.dto.TicketRequestDTO;
import com.gagan.ticketmanagementsystem.dto.TicketUpdateDTO;
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
        return ticketRepository.findByIsDeletedFalse();
    }

    public Ticket getTicketById(Integer id){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Ticket with ID " + id + " not found"));

        if(ticket.isDeleted()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Ticket has been deleted!");
        }
        return ticket;
    }

    public Ticket updateTicket(Integer id, TicketUpdateDTO ticketUpdateDTO){
        Ticket existingTicket = getTicketById(id);

        if(ticketUpdateDTO.getTitle() != null) existingTicket.setTitle(ticketUpdateDTO.getTitle());
        if(ticketUpdateDTO.getDescription() != null) existingTicket.setDescription(ticketUpdateDTO.getDescription());
        if(ticketUpdateDTO.getStatus() != null) existingTicket.setStatus(ticketUpdateDTO.getStatus());
        if(ticketUpdateDTO.getPriority() != null) existingTicket.setPriority(ticketUpdateDTO.getPriority());

        if(ticketUpdateDTO.getAssignedToId() != null){
            User user = userRepository.findById(ticketUpdateDTO.getAssignedToId())
                    .orElseThrow(()-> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,"user with ID " +ticketUpdateDTO.getAssignedToId() + " not found"));
            existingTicket.setAssignedTo(user);
        }
        return ticketRepository.save(existingTicket);
    }

    public void softDeleteTicket(Integer id){
        Ticket ticket = getTicketById(id);
        ticket.setDeleted(true);
        ticket.setStatus("DELETED");
        ticketRepository.save(ticket);
    }

    public List<Ticket> getTicketByStatus(String status){
        String upperStatus = status.toUpperCase();
        List<String> validStatus = List.of("OPEN", "IN_PROGRESS", "RESOLVED");

        if(!validStatus.contains(upperStatus)){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid Status Value"
            );
        }
        return ticketRepository.findByStatusAndIsDeletedFalse(upperStatus);
    }

    public List<Ticket> getTicketByCreatedUser(Integer id){
        if(!userRepository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User with ID " + id + " not found"
            );
        }
        return ticketRepository.findByCreatedByIdAndIsDeletedFalse(id);
    }

    public List<Ticket> getTicketByAssignedUser(Integer id){
        if(!userRepository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User with ID " + id + " not found"
            );
        }
        return ticketRepository.findByAssignedToIdAndIsDeletedFalse(id);
    }

    public List<Ticket> getTicketByPriority(String priority){
        return ticketRepository.findByPriorityAndIsDeletedFalse(priority);
    }
}
