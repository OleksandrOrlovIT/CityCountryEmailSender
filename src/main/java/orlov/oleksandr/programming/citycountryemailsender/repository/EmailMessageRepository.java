package orlov.oleksandr.programming.citycountryemailsender.repository;

import org.springframework.data.repository.CrudRepository;
import orlov.oleksandr.programming.citycountryemailsender.model.EmailMessage;

public interface EmailMessageRepository extends CrudRepository<EmailMessage, String> {
}