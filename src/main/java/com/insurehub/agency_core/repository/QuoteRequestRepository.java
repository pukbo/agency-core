package com.insurehub.agency_core.repository;

import com.insurehub.agency_core.entity.QuoteRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRequestRepository extends JpaRepository<QuoteRequest, Long> {
}
