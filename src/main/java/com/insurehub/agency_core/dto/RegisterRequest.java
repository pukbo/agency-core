package com.insurehub.agency_core.dto;

import com.insurehub.agency_core.enums.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role; // Opzionale o forzato a CUSTOMER a seconda della logica
}
