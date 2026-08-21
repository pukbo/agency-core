package com.insurehub.agency_core.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurehub.agency_core.dto.QuoteRequestDTO;
import com.insurehub.agency_core.entity.User;
import com.insurehub.agency_core.repository.UserRepository;
import com.insurehub.agency_core.service.QuoteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/quotes")
@RequiredArgsConstructor
public class AdminQuoteController {

    private final QuoteService quoteService;
    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Page<QuoteRequestDTO>> getQuotes(
            @RequestParam(required = false) String status,
            Pageable pageable) {
        return ResponseEntity.ok(quoteService.getQuoteRequests(status, pageable));
    }

    @PostMapping("/{id}/assign")
    public ResponseEntity<QuoteRequestDTO> assignQuoteToSelf(
            @PathVariable Long id,
            @AuthenticationPrincipal UserDetails userDetails) {
        
        User agent = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
                
        return ResponseEntity.ok(quoteService.assignQuote(id, agent));
    }
}
