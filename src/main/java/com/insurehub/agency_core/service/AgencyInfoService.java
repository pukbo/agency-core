package com.insurehub.agency_core.service;

import com.insurehub.agency_core.entity.AgencyInfo;
import com.insurehub.agency_core.repository.AgencyInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyInfoService {

    private final AgencyInfoRepository agencyInfoRepository;

    public AgencyInfoService(AgencyInfoRepository agencyInfoRepository) {
        this.agencyInfoRepository = agencyInfoRepository;
    }

    public AgencyInfo saveAgencyInfo(AgencyInfo agencyInfo) {
        return agencyInfoRepository.save(agencyInfo);
    }

    public List<AgencyInfo> getAllAgencyInfos() {
        return agencyInfoRepository.findAll();
    }

    public Optional<AgencyInfo> getAgencyInfoById(Long id) {
        return agencyInfoRepository.findById(id);
    }
}
