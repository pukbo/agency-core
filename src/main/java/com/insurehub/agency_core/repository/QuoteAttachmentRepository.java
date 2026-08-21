package com.insurehub.agency_core.repository;

import com.insurehub.agency_core.entity.QuoteAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuoteAttachmentRepository extends JpaRepository<QuoteAttachment, Long> {
    List<QuoteAttachment> findByQuoteRequestId(Long quoteRequestId);
}
