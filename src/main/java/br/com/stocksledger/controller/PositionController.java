package br.com.stocksledger.controller;

import br.com.stocksledger.model.Position;
import br.com.stocksledger.model.PositionDetailDTO;
import br.com.stocksledger.model.PositionListDTO;
import br.com.stocksledger.model.PositionResultDTO;
import br.com.stocksledger.service.PositionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/position")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @PostMapping("/new")
    public ResponseEntity<Position> newPosition(@RequestBody Position position) throws JsonProcessingException {
        var jsonPosition = new ObjectMapper().writeValueAsString(position);
        log.info("Add new position request received: Position: [{}]", jsonPosition);
        return ResponseEntity.created(null).body(positionService.addNewPosition(position));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Position>> getAllPosition(){
        return ResponseEntity.ok(positionService.getAllPositions());
    }

    @GetMapping("all/grouped")
    public ResponseEntity<List<PositionResultDTO>> getGroupedPositionDetails(){
        return ResponseEntity.ok(positionService.getGroupedPositionDetail());
    }

    @GetMapping("/all/{ticker}")
    public ResponseEntity<PositionListDTO> getPositionDetails(@PathVariable String ticker,
                                                              @RequestParam Double currentPrice){

        return ResponseEntity.ok(positionService.getPositionDetail(ticker, currentPrice));
    }

}
