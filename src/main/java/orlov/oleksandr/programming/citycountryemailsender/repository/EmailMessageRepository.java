package orlov.oleksandr.programming.citycountryemailsender.repository;

import org.springframework.data.repository.CrudRepository;
import orlov.oleksandr.programming.citycountryemailsender.model.EmailMessage;

import java.util.List;

public interface EmailMessageRepository extends CrudRepository<EmailMessage, String> {
    List<EmailMessage> findByErrorMessageIsNotNull();
}