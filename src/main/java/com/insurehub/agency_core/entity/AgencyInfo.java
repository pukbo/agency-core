package com.insurehub.agency_core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "agency_info")
@Getter
@Setter
public class AgencyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    private String primaryColor;
    private String secondaryColor;
    private String logoUrl;

    @Column(nullable = false)
    private String contactEmail;

    private String phone;
    private String vatNumber;
}
