package com.insurehub.agency_core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurehub.agency_core.dto.QuoteRequestDTO;
import com.insurehub.agency_core.service.QuoteService;

import jakarta.validation.Valid;

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
    @PostMapping("/{id}/attachments")
    public ResponseEntity<?> uploadAttachment(
            @org.springframework.web.bind.annotation.PathVariable Long id,
            @org.springframework.web.bind.annotation.RequestParam("file") org.springframework.web.multipart.MultipartFile file) {
        
        try {
            String fileName = quoteService.addAttachmentToQuote(id, file);
            return ResponseEntity.ok("File " + fileName + " caricato con successo per il preventivo " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Errore durante l'upload del file: " + e.getMessage());
        }
    }
}
