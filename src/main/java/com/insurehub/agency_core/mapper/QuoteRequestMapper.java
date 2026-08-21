package com.insurehub.agency_core.mapper;

import com.insurehub.agency_core.dto.QuoteRequestDTO;
import com.insurehub.agency_core.entity.QuoteRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuoteRequestMapper {

    QuoteRequestDTO toDto(QuoteRequest entity);

    QuoteRequest toEntity(QuoteRequestDTO dto);
}
