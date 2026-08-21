package com.insurehub.agency_core.controller;

import com.insurehub.agency_core.dto.AgencyInfoDTO;
import com.insurehub.agency_core.service.AgencyInfoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/agency-info")
public class AgencyInfoController {

    private final AgencyInfoService agencyInfoService;

    public AgencyInfoController(AgencyInfoService agencyInfoService) {
        this.agencyInfoService = agencyInfoService;
    }

    @PostMapping
    public ResponseEntity<AgencyInfoDTO> createAgencyInfo(@Valid @RequestBody AgencyInfoDTO agencyInfoDTO) {
        AgencyInfoDTO savedAgencyInfo = agencyInfoService.saveAgencyInfo(agencyInfoDTO);
        return new ResponseEntity<>(savedAgencyInfo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<AgencyInfoDTO> getAgencyInfo() {
        // Poiché è Single-Tenant, assumiamo che l'agenzia abbia sempre ID 1 o ne estraiamo il primo record
        return ResponseEntity.ok(agencyInfoService.getAgencyInfoById(1L));
    }

    @PutMapping
    public ResponseEntity<AgencyInfoDTO> updateAgencyInfo(@Valid @RequestBody AgencyInfoDTO agencyInfoDTO) {
        // Poiché è Single-Tenant, forziamo l'aggiornamento del record 1
        agencyInfoDTO.setId(1L);
        AgencyInfoDTO updatedAgencyInfo = agencyInfoService.saveAgencyInfo(agencyInfoDTO);
        return ResponseEntity.ok(updatedAgencyInfo);
    }
}
