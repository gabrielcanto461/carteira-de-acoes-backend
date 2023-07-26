package br.com.stocksledger.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PositionListDTO {
    private List<Position> positions;
    private PositionResultDTO positionResult;
}
