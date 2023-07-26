package br.com.stocksledger.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PositionResultDTO {
    private StocksDataDTO ticketsData;
    private Long quantity;
    private Double investedAmount;
    private Double averagePrice;
    private Double yield;
    private Double netAmount;
    private Double netEarning;
}
