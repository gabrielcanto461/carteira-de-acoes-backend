package br.com.stocksledger.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Ticket {

    private Long ticketId;
    private String symbol;
    private String shortName;
    private String longName;
}
