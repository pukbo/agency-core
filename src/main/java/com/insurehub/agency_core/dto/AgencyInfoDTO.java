package com.insurehub.agency_core.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgencyInfoDTO {

    private Long id;

    @NotBlank(message = "Il nome dell'agenzia è obbligatorio")
    private String companyName;

    private String primaryColor;
    private String secondaryColor;
    private String logoUrl;

    @NotBlank(message = "L'email di contatto è obbligatoria")
    @Email(message = "L'email di contatto non è valida")
    private String contactEmail;

    private String phone;
    private String vatNumber;
}
