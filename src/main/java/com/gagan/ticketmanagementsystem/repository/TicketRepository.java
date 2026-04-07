package com.gagan.ticketmanagementsystem.repository;

import com.gagan.ticketmanagementsystem.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository <Ticket,Integer> {
    List<Ticket> findByIsDeletedFalse();

    List<Ticket> findByStatusAndIsDeletedFalse(String status);

    List<Ticket> findByCreatedByIdAndIsDeletedFalse(Integer id);

    List<Ticket> findByAssignedToIdAndIsDeletedFalse(Integer id);
}
