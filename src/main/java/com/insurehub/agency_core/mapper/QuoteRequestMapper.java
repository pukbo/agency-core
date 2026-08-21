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

    @Mapping(source = "productId", target = "product")
    @Mapping(source = "assignedToId", target = "assignedTo")
    QuoteRequest toEntity(QuoteRequestDTO dto);

    default com.insurehub.agency_core.entity.User mapUser(Long id) {
        if (id == null) {
            return null;
        }
        com.insurehub.agency_core.entity.User user = new com.insurehub.agency_core.entity.User();
        user.setId(id);
        return user;
    }

    default com.insurehub.agency_core.entity.InsuranceProduct mapProduct(Long id) {
        if (id == null) {
            return null;
        }
        com.insurehub.agency_core.entity.InsuranceProduct product = new com.insurehub.agency_core.entity.InsuranceProduct();
        product.setId(id);
        return product;
    }
}
