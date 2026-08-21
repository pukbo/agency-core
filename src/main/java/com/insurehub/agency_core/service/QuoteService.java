package com.insurehub.agency_core.service;

import com.insurehub.agency_core.entity.QuoteRequest;
import com.insurehub.agency_core.repository.QuoteRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuoteService {

    private final QuoteRequestRepository quoteRequestRepository;

    public QuoteService(QuoteRequestRepository quoteRequestRepository) {
        this.quoteRequestRepository = quoteRequestRepository;
    }

    public QuoteRequest saveQuoteRequest(QuoteRequest quoteRequest) {
        return quoteRequestRepository.save(quoteRequest);
    }

    public List<QuoteRequest> getAllQuoteRequests() {
        return quoteRequestRepository.findAll();
    }

    public Optional<QuoteRequest> getQuoteRequestById(Long id) {
        return quoteRequestRepository.findById(id);
    }
}
