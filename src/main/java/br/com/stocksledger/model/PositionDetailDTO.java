package br.com.stocksledger.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PositionDetailDTO {
    private String ticker;
    private Long quantity;
    private Double averagePrice;
    private Double investedAmount;
}
