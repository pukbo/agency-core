package com.insurehub.agency_core.service;

import org.springframework.stereotype.Service;

import com.insurehub.agency_core.dto.QuoteRequestDTO;
import com.insurehub.agency_core.entity.QuoteRequest;
import com.insurehub.agency_core.exception.ResourceNotFoundException;
import com.insurehub.agency_core.mapper.QuoteRequestMapper;
import com.insurehub.agency_core.repository.QuoteRequestRepository;

@Service
public class QuoteService {

    private final QuoteRequestRepository quoteRequestRepository;
    private final QuoteRequestMapper quoteRequestMapper;
    private final EmailService emailService;
    private final FileStorageService fileStorageService;
    private final com.insurehub.agency_core.repository.QuoteAttachmentRepository quoteAttachmentRepository;

    public QuoteService(QuoteRequestRepository quoteRequestRepository, QuoteRequestMapper quoteRequestMapper, EmailService emailService, FileStorageService fileStorageService, com.insurehub.agency_core.repository.QuoteAttachmentRepository quoteAttachmentRepository) {
        this.quoteRequestRepository = quoteRequestRepository;
        this.quoteRequestMapper = quoteRequestMapper;
        this.emailService = emailService;
        this.fileStorageService = fileStorageService;
        this.quoteAttachmentRepository = quoteAttachmentRepository;
    }

    public QuoteRequestDTO saveQuoteRequest(QuoteRequestDTO quoteRequestDTO) {
        QuoteRequest quoteRequest = quoteRequestMapper.toEntity(quoteRequestDTO);
        QuoteRequest savedQuote = quoteRequestRepository.save(quoteRequest);
        
        // Invia notifica email al cliente
        emailService.sendQuoteConfirmation(savedQuote.getEmail(), savedQuote.getFirstName());
        
        return quoteRequestMapper.toDto(savedQuote);
    }

    public org.springframework.data.domain.Page<QuoteRequestDTO> getQuoteRequests(String status, org.springframework.data.domain.Pageable pageable) {
        if (status != null && !status.isEmpty()) {
            return quoteRequestRepository.findByStatus(com.insurehub.agency_core.enums.QuoteStatus.valueOf(status.toUpperCase()), pageable)
                    .map(quoteRequestMapper::toDto);
        }
        return quoteRequestRepository.findAll(pageable)
                .map(quoteRequestMapper::toDto);
    }

    public QuoteRequestDTO getQuoteRequestById(Long id) {
        QuoteRequest quoteRequest = quoteRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Richiesta di preventivo non trovata con id: " + id));
        return quoteRequestMapper.toDto(quoteRequest);
    }
    
    public QuoteRequestDTO assignQuote(Long id, com.insurehub.agency_core.entity.User agent) {
        QuoteRequest quoteRequest = quoteRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Richiesta di preventivo non trovata con id: " + id));
        
        quoteRequest.setAssignedTo(agent);
        quoteRequest.setStatus(com.insurehub.agency_core.enums.QuoteStatus.IN_PROGRESS);
        QuoteRequest saved = quoteRequestRepository.save(quoteRequest);
        return quoteRequestMapper.toDto(saved);
    }
    
    public String addAttachmentToQuote(Long quoteId, org.springframework.web.multipart.MultipartFile file) {
        QuoteRequest quoteRequest = quoteRequestRepository.findById(quoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Richiesta di preventivo non trovata con id: " + quoteId));

        String savedFileName = fileStorageService.storeFile(file);

        com.insurehub.agency_core.entity.QuoteAttachment attachment = new com.insurehub.agency_core.entity.QuoteAttachment();
        attachment.setQuoteRequest(quoteRequest);
        attachment.setFileName(file.getOriginalFilename());
        attachment.setFileType(file.getContentType());
        attachment.setFilePath(savedFileName);

        quoteAttachmentRepository.save(attachment);

        return file.getOriginalFilename();
    }
}
