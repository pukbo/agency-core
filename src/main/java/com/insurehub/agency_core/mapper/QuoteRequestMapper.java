package com.insurehub.agency_core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.insurehub.agency_core.dto.QuoteRequestDTO;
import com.insurehub.agency_core.entity.QuoteRequest;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuoteRequestMapper {

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "assignedTo.id", target = "assignedToId")
    QuoteRequestDTO toDto(QuoteRequest entity);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "assignedToId", target = "assignedTo.id")
    QuoteRequest toEntity(QuoteRequestDTO dto);
}
