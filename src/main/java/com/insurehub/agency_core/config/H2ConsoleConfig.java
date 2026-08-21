package com.insurehub.agency_core.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfig {

    @Bean
    public ServletRegistrationBean<org.h2.server.web.JakartaWebServlet> h2servletRegistration() {
        ServletRegistrationBean<org.h2.server.web.JakartaWebServlet> registrationBean = new ServletRegistrationBean<>(new org.h2.server.web.JakartaWebServlet());
        registrationBean.addUrlMappings("/h2-console/*");
        registrationBean.addInitParameter("webAllowOthers", "true");
        return registrationBean;
    }
}
