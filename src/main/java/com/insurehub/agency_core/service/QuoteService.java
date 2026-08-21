package com.insurehub.agency_core.service;

import com.insurehub.agency_core.dto.QuoteRequestDTO;
import com.insurehub.agency_core.entity.QuoteRequest;
import com.insurehub.agency_core.exception.ResourceNotFoundException;
import com.insurehub.agency_core.mapper.QuoteRequestMapper;
import com.insurehub.agency_core.repository.QuoteRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuoteService {

    private final QuoteRequestRepository quoteRequestRepository;
    private final QuoteRequestMapper quoteRequestMapper;

    public QuoteService(QuoteRequestRepository quoteRequestRepository, QuoteRequestMapper quoteRequestMapper) {
        this.quoteRequestRepository = quoteRequestRepository;
        this.quoteRequestMapper = quoteRequestMapper;
    }

    public QuoteRequestDTO saveQuoteRequest(QuoteRequestDTO quoteRequestDTO) {
        QuoteRequest quoteRequest = quoteRequestMapper.toEntity(quoteRequestDTO);
        QuoteRequest savedQuote = quoteRequestRepository.save(quoteRequest);
        return quoteRequestMapper.toDto(savedQuote);
    }

    public List<QuoteRequestDTO> getAllQuoteRequests() {
        return quoteRequestRepository.findAll().stream()
                .map(quoteRequestMapper::toDto)
                .collect(Collectors.toList());
    }

    public QuoteRequestDTO getQuoteRequestById(Long id) {
        QuoteRequest quoteRequest = quoteRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QuoteRequest not found with id: " + id));
        return quoteRequestMapper.toDto(quoteRequest);
    }
}
