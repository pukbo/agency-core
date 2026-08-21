package com.insurehub.agency_core.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.insurehub.agency_core.entity.User;
import com.insurehub.agency_core.enums.Role;
import com.insurehub.agency_core.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByEmail("admin@agency.com").isEmpty()) {
            User admin = new User();
            admin.setFirstName("Admin");
            admin.setLastName("Agency");
            admin.setEmail("admin@agency.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(Role.ADMIN);
            userRepository.save(admin);
            System.out.println("Utente ADMIN di default creato: admin@agency.com / admin123");
        }
    }
}
