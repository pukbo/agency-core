package com.insurehub.agency_core.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendQuoteConfirmation(String toEmail, String firstName) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("no-reply@insurehubdemo.com");
            message.setTo(toEmail);
            message.setSubject("Conferma ricezione preventivo");
            message.setText("Ciao " + firstName + ",\n\nAbbiamo ricevuto la tua richiesta di preventivo. Un nostro agente la prenderà in carico a breve e ti contatterà.\n\nGrazie,\nIl team di InsureHub");
            
            mailSender.send(message);
            log.info("Email di conferma inviata a: {}", toEmail);
        } catch (org.springframework.mail.MailException e) {
            log.warn("Impossibile connettersi al server email fittizio locale (localhost:1025). L'email a {} non è stata inviata, ma l'applicazione continua a funzionare. Dettagli: {}", toEmail, e.getMessage());
        } catch (Exception e) {
            log.error("Errore imprevisto durante l'invio dell'email a {}: {}", toEmail, e.getMessage());
        }
    }
}
