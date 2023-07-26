package br.com.stocksledger.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StocksDTO {
    private String stock;
    private String name;
    private double close;
    private double change;
    private int volume;
    private long market_cap;
    private String logo;
    private String sector;
}
