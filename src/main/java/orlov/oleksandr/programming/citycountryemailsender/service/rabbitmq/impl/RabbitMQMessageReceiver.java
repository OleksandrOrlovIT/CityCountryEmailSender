package orlov.oleksandr.programming.citycountryemailsender.service.rabbitmq.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import orlov.oleksandr.programming.citycountryemailsender.model.EmailMessage;
import orlov.oleksandr.programming.citycountryemailsender.model.SendStatus;
import orlov.oleksandr.programming.citycountryemailsender.service.elasticSearch.EmailMessageService;
import orlov.oleksandr.programming.citycountryemailsender.service.email.EmailService;
import orlov.oleksandr.programming.citycountryemailsender.service.rabbitmq.MessageReceiver;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class RabbitMQMessageReceiver implements MessageReceiver {

    private final EmailMessageService emailMessageService;
    private final EmailService emailService;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void receiveMessage(String message) {
        try {
            Map<String, String> messageContent = objectMapper.readValue(message, Map.class);
            String subject = messageContent.get("subject");
            String content = messageContent.get("content");
            String email = messageContent.get("email");

            boolean isSent = sentReceivedMessage(messageContent);

            EmailMessage emailMessage = EmailMessage.builder()
                    .subject(subject)
                    .content(content)
                    .email(email)
                    .sendStatus(isSent ? SendStatus.SENT : SendStatus.ERROR_WHILE_SENDING)
                    .build();

            EmailMessage savedEmailMessage = emailMessageService.save(emailMessage);
            log.info("Saved email message {}", savedEmailMessage);

        } catch (JsonProcessingException e) {
            log.error("Failed to parse message", e);
        }
    }

    public boolean sentReceivedMessage(Map<String, String> messageContent) {
        try {
            emailService.sendEmail(
                    messageContent.get("email"),
                    messageContent.get("subject"),
                    messageContent.get("content")
            );

            return true;
        } catch (Exception e) {
            log.error("Failed to send email", e);
            return false;
        }
    }
}