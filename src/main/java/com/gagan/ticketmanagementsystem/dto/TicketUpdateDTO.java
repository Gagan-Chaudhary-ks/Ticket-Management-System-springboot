package com.gagan.ticketmanagementsystem.dto;

import lombok.Data;

@Data
public class TicketUpdateDTO {
    private String title;
    private String description;
    private String status;
    private String priority;
    private Integer assignedToId;
}
