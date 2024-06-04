package orlov.oleksandr.programming.citycountryemailsender.service.elasticSearch.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import orlov.oleksandr.programming.citycountryemailsender.model.EmailMessage;
import orlov.oleksandr.programming.citycountryemailsender.repository.EmailMessageRepository;
import orlov.oleksandr.programming.citycountryemailsender.service.elasticSearch.EmailMessageService;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmailMessageServiceImpl implements EmailMessageService {

    private final EmailMessageRepository emailMessageRepository;

    @Override
    public EmailMessage save(EmailMessage emailMessage) {
        emailMessage.setLastTryDate(ZonedDateTime.now(ZoneId.of("Europe/Kiev")));
        return emailMessageRepository.save(emailMessage);
    }

    @Override
    public List<EmailMessage> findAllFailedMessages() {
        return emailMessageRepository.findByErrorMessageIsNotNull();
    }
}