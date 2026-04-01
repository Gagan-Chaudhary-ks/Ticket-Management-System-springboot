package com.gagan.ticketmanagementsystem.dto;

import lombok.Data;

@Data
public class TicketRequestDTO {
    private String title;
    private String description;
    private Integer creatorId;
    private Integer assignedToId;

}
