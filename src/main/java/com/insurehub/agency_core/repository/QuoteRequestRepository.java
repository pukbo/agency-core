package com.insurehub.agency_core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurehub.agency_core.entity.QuoteRequest;
import com.insurehub.agency_core.enums.QuoteStatus;

@Repository
public interface QuoteRequestRepository extends JpaRepository<QuoteRequest, Long> {
    Page<QuoteRequest> findByStatus(QuoteStatus status, Pageable pageable);
}
