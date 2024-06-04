package orlov.oleksandr.programming.citycountryemailsender.service.schedule.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import orlov.oleksandr.programming.citycountryemailsender.model.EmailMessage;
import orlov.oleksandr.programming.citycountryemailsender.service.elasticSearch.EmailMessageService;
import orlov.oleksandr.programming.citycountryemailsender.service.email.EmailService;
import orlov.oleksandr.programming.citycountryemailsender.service.schedule.EmailScheduleService;

@Slf4j
@AllArgsConstructor
@Service
public class EmailScheduleServiceImpl implements EmailScheduleService {

    private final EmailService emailService;
    private final EmailMessageService emailMessageService;

    @Scheduled(fixedDelay = 300000)
    @Override
    public void sendEmailMessagesWithErrors() {
        for(EmailMessage emailMessage : emailMessageService.findAllFailedMessages()){
            EmailMessage sentEmailMessage = emailService.sendEmailMessage(emailMessage);

            EmailMessage savedEmailMessage = emailMessageService.save(sentEmailMessage);

            log.info("Saved email message {}", savedEmailMessage);
        }
    }
}
