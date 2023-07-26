package br.com.stocksledger.model;

import lombok.Data;

import java.util.Date;

@Data
public class TicketsData {
    private String symbol;
    private String shortName;
    private String longName;
    private String currency;
    private Double regularMarketPrice;
    private Double regularMarketDayHigh;
    private Double regularMarketDayLow;
    private String regularMarketDayRange;
    private Double regularMarketChange;
    private Double regularMarketChangePercent;
    private Date regularMarketTime;
    private Long marketCap;
    private Integer regularMarketVolume;
    private Double regularMarketPreviousClose;
    private Double regularMarketOpen;
    private Integer averageDailyVolume10Day;
    private Integer averageDailyVolume3Month;
    private Double fiftyTwoWeekLowChange;
    private Double fiftyTwoWeekLowChangePercent;
    private String fiftyTwoWeekRange;
    private Double fiftyTwoWeekHighChange;
    private Double fiftyTwoWeekHighChangePercent;
    private Double fiftyTwoWeekLow;
    private Double fiftyTwoWeekHigh;
    private Double twoHundredDayAverage;
    private Double twoHundredDayAverageChange;
    private Double twoHundredDayAverageChangePercent;
    private String logourl;
}
