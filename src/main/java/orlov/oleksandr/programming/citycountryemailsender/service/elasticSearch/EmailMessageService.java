package orlov.oleksandr.programming.citycountryemailsender.service.elasticSearch;

import orlov.oleksandr.programming.citycountryemailsender.model.EmailMessage;

import java.util.List;
import java.util.Optional;

public interface EmailMessageService {
    EmailMessage save(EmailMessage emailMessage);

    List<EmailMessage> findAllFailedMessages();
}