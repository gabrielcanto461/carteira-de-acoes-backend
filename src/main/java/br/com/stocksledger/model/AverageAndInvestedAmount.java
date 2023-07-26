package br.com.stocksledger.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AverageAndInvestedAmount {
    private String ticker;
    private Long quantity;
    private Double averagePrice;
    private Double investedAmount;
}