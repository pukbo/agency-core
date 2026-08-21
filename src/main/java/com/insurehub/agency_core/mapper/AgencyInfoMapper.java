package com.insurehub.agency_core.mapper;

import com.insurehub.agency_core.dto.AgencyInfoDTO;
import com.insurehub.agency_core.entity.AgencyInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AgencyInfoMapper {

    AgencyInfoDTO toDto(AgencyInfo entity);

    AgencyInfo toEntity(AgencyInfoDTO dto);
}
