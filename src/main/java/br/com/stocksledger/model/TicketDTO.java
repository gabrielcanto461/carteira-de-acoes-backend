package br.com.stocksledger.model;

import lombok.Data;

@Data
public class TicketDTO {
    private String symbol;
    private String shortName;
    private String longName;
    private String currency;
    private Double regularMarketPrice;
}
