package com.insurehub.agency_core.controller;

import com.insurehub.agency_core.entity.QuoteRequest;
import com.insurehub.agency_core.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping
    public ResponseEntity<QuoteRequest> createQuoteRequest(@RequestBody QuoteRequest quoteRequest) {
        QuoteRequest savedQuote = quoteService.saveQuoteRequest(quoteRequest);
        return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
    }
}
