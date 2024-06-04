package orlov.oleksandr.programming.citycountryemailsender.service.email.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import orlov.oleksandr.programming.citycountryemailsender.model.EmailMessage;
import orlov.oleksandr.programming.citycountryemailsender.model.SendStatus;
import orlov.oleksandr.programming.citycountryemailsender.service.email.EmailService;

@AllArgsConstructor
@Service
@Slf4j
public class CustomEmailService implements EmailService {

    private final JavaMailSender emailSender;

    @Override
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public EmailMessage sendEmailMessage(EmailMessage emailMessage){
        try {
            sendEmail(emailMessage.getEmail(), emailMessage.getSubject(), emailMessage.getContent());
            emailMessage.setSendStatus(SendStatus.SENT);
            emailMessage.setErrorMessage(null);
        } catch (Exception e){
            log.error("Failed to send email", e);
            emailMessage.setSendStatus(SendStatus.ERROR_WHILE_SENDING);
            emailMessage.setErrorMessage(e.getClass().getName() + ": " + e.getMessage());
        }

        emailMessage.setTryCount(emailMessage.getTryCount() == null ? 1 : emailMessage.getTryCount() + 1);
        return emailMessage;
    }
}