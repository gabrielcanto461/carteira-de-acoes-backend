package br.com.stocksledger.service;

import br.com.stocksledger.PositionRepository;
import br.com.stocksledger.exception.PositionNotFoundException;
import br.com.stocksledger.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;

    public Position addNewPosition(Position position) {
        position = positionRepository.save(position);

        return position;
    }

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public PositionListDTO getPositionDetail(String ticker, Double currentPrice) {
        var allTickerPositions = positionRepository.findAllByTickerIgnoreCase(ticker);

        var ticketData = getTicketsData(ticker);

        if (allTickerPositions.isEmpty()) {
            throw new PositionNotFoundException("Nenhuma posição foi encontrada para o papel informado");
        }

        var averagePrice =
                allTickerPositions.stream()
                        .mapToDouble(Position::getPrice)
                        .average()
                        .orElseThrow(() -> new RuntimeException("Error ao calcular o preço médio!"));

        var investedAmount =
                allTickerPositions.stream()
                        .mapToLong(Position::getQuantity)
                        .mapToDouble(value -> value * averagePrice)
                        .sum();

        var netAmount =
                allTickerPositions.stream()
                        .mapToLong(Position::getQuantity)
                        .mapToDouble(value -> value * ticketData.getResults().get(0).getRegularMarketPrice())
                        .sum();

        var quantity =
                allTickerPositions.stream()
                        .mapToLong(Position::getQuantity)
                        .sum();

        var yield = (netAmount / investedAmount - 1) * 100;
        var liquidEarning = netAmount - investedAmount;

        return PositionListDTO.builder()
                .positions(allTickerPositions)
                .positionResult(
                        PositionResultDTO.builder()
                                .ticketsData(ticketData)
                                .averagePrice(averagePrice)
                                .investedAmount(investedAmount)
                                .netAmount(netAmount)
                                .yield(yield)
                                .quantity(quantity)
                                .netEarning(liquidEarning)
                                .build()
                ).build();
    }

    public List<PositionResultDTO> getGroupedPositionDetail() {
        List<Position> positions = positionRepository.findAll();
        var positionDetail = positionRepository.findPositionDetail();

        var positionDetails = new ArrayList<PositionResultDTO>();

        positionDetail.forEach((group) -> {
            var ticketData = getTicketsData(group.getTicker());
            var averagePrice = group.getAveragePrice();
            var quantity = group.getQuantity();
            var investedAmount = quantity*averagePrice;
            var netAmount = ticketData.getResults().get(0).getRegularMarketPrice()*quantity;
            var yield = ((netAmount / investedAmount) - 1)*100;
            var netEarning = netAmount - investedAmount;

            positionDetails.add(
                    PositionResultDTO.builder()
                            .ticketsData(ticketData)
                            .quantity(quantity)
                            .investedAmount(group.getInvestedAmount())
                            .averagePrice(group.getAveragePrice())
                            .yield(yield)
                            .netAmount(netAmount)
                            .netEarning(netEarning)
                            .build());
        });

        return positionDetails;
    }

    private StocksDataDTO getTicketsData(String ticker) {
        var restTemplate = new RestTemplateBuilder().build();

        var uri = String.format("https://brapi.dev/api/quote/%s?range=1d&interval=1d&fundamental=true", ticker);

        var response = restTemplate.getForEntity(uri, StocksDataDTO.class);

        return response.getBody();
    }
}
