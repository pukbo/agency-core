package com.insurehub.agency_core.controller;

import com.insurehub.agency_core.entity.AgencyInfo;
import com.insurehub.agency_core.service.AgencyInfoService;
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

    @GetMapping
    public ResponseEntity<List<AgencyInfo>> getAgencyInfo() {
        List<AgencyInfo> agencyInfos = agencyInfoService.getAllAgencyInfos();
        return ResponseEntity.ok(agencyInfos);
    }
}
