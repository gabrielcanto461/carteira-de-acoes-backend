package br.com.stocksledger.controller;

import br.com.stocksledger.model.TicketDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketsController {

    @GetMapping("/ticket/{ticker}")
    public ResponseEntity<TicketDTO> retrieveTicketData(@RequestParam String ticker){

        return ResponseEntity.ok(null);
    }

}
