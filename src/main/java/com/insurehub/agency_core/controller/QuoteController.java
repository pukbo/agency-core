package com.insurehub.agency_core.controller;

import com.insurehub.agency_core.dto.QuoteRequestDTO;
import com.insurehub.agency_core.service.QuoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping
    public ResponseEntity<QuoteRequestDTO> createQuoteRequest(@Valid @RequestBody QuoteRequestDTO quoteRequestDTO) {
        QuoteRequestDTO savedQuote = quoteService.saveQuoteRequest(quoteRequestDTO);
        return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
    }

}
