package com.insurehub.agency_core.service;

import com.insurehub.agency_core.dto.AgencyInfoDTO;
import com.insurehub.agency_core.entity.AgencyInfo;
import com.insurehub.agency_core.exception.ResourceNotFoundException;
import com.insurehub.agency_core.mapper.AgencyInfoMapper;
import com.insurehub.agency_core.repository.AgencyInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgencyInfoService {

    private final AgencyInfoRepository agencyInfoRepository;
    private final AgencyInfoMapper agencyInfoMapper;

    public AgencyInfoService(AgencyInfoRepository agencyInfoRepository, AgencyInfoMapper agencyInfoMapper) {
        this.agencyInfoRepository = agencyInfoRepository;
        this.agencyInfoMapper = agencyInfoMapper;
    }

    public AgencyInfoDTO saveAgencyInfo(AgencyInfoDTO agencyInfoDTO) {
        AgencyInfo agencyInfo = agencyInfoMapper.toEntity(agencyInfoDTO);
        AgencyInfo savedAgencyInfo = agencyInfoRepository.save(agencyInfo);
        return agencyInfoMapper.toDto(savedAgencyInfo);
    }

    public List<AgencyInfoDTO> getAllAgencyInfos() {
        return agencyInfoRepository.findAll().stream()
                .map(agencyInfoMapper::toDto)
                .collect(Collectors.toList());
    }

    public AgencyInfoDTO getAgencyInfoById(Long id) {
        AgencyInfo agencyInfo = agencyInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Informazioni agenzia non trovate con id: " + id));
        return agencyInfoMapper.toDto(agencyInfo);
    }
}
