package com.insurehub.agency_core.mapper;

import com.insurehub.agency_core.dto.QuoteRequestDTO;
import com.insurehub.agency_core.entity.QuoteRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import org.mapstruct.Mapping;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuoteRequestMapper {

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "assignedTo.id", target = "assignedToId")
    QuoteRequestDTO toDto(QuoteRequest entity);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "assignedToId", target = "assignedTo.id")
    QuoteRequest toEntity(QuoteRequestDTO dto);
}
