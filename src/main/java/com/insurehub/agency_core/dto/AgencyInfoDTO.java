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
    private String name;

    @NotBlank(message = "L'indirizzo è obbligatorio")
    private String address;

    @NotBlank(message = "Il numero di telefono è obbligatorio")
    private String phone;

    @NotBlank(message = "L'email di contatto è obbligatoria")
    @Email(message = "L'email di contatto non è valida")
    private String contactEmail;
}
