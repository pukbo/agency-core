package com.insurehub.agency_core.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuoteRequestDTO {

    private Long id;

    @NotBlank(message = "Il nome è obbligatorio")
    private String firstName;

    @NotBlank(message = "Il cognome è obbligatorio")
    private String lastName;

    @NotBlank(message = "L'email è obbligatoria")
    @Email(message = "L'email non è valida")
    private String email;

    @NotBlank(message = "Il numero di telefono è obbligatorio")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Il formato del numero di telefono non è valido")
    private String phone;

    private Long productId;

    // TODO: Deprecare e rimuovere dopo la transizione a productId
    private String policyType;

    private String status;

    private Long assignedToId;

    private Map<String, Object> quoteData;

    private LocalDateTime createdAt;
}
