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
    public ResponseEntity<List<AgencyInfoDTO>> getAllAgencyInfo() {
        return ResponseEntity.ok(agencyInfoService.getAllAgencyInfos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgencyInfoDTO> getAgencyInfoById(@PathVariable Long id) {
        return ResponseEntity.ok(agencyInfoService.getAgencyInfoById(id));
    }
}
