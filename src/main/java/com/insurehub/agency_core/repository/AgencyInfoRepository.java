package com.insurehub.agency_core.repository;

import com.insurehub.agency_core.entity.AgencyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyInfoRepository extends JpaRepository<AgencyInfo, Long> {
}
