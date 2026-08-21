package com.insurehub.agency_core.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.insurehub.agency_core.entity.User;
import com.insurehub.agency_core.enums.Role;
import com.insurehub.agency_core.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import com.insurehub.agency_core.repository.AgencyInfoRepository;
import com.insurehub.agency_core.entity.AgencyInfo;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AgencyInfoRepository agencyInfoRepository;

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

        if (agencyInfoRepository.count() == 0) {
            AgencyInfo info = new AgencyInfo();
            info.setCompanyName("InsureHub Demo");
            info.setPrimaryColor("#0056b3");
            info.setSecondaryColor("#ffc107");
            info.setLogoUrl("https://via.placeholder.com/150x50?text=Logo");
            info.setContactEmail("info@insurehubdemo.com");
            info.setPhone("+39021234567");
            info.setVatNumber("IT12345678901");
            agencyInfoRepository.save(info);
            System.out.println("Impostazioni agenzia (White-Label) di default create.");
        }
    }
}
