package orlov.oleksandr.programming.citycountryemailsender.service.elasticSearch.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import orlov.oleksandr.programming.citycountryemailsender.model.EmailMessage;
import orlov.oleksandr.programming.citycountryemailsender.repository.EmailMessageRepository;
import orlov.oleksandr.programming.citycountryemailsender.service.elasticSearch.EmailMessageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmailMessageServiceImpl implements EmailMessageService {

    private final EmailMessageRepository emailMessageRepository;

    @Override
    public EmailMessage save(EmailMessage emailMessage) {
        return emailMessageRepository.save(emailMessage);
    }

    @Override
    public Optional<EmailMessage> findById(String id) {
        return emailMessageRepository.findById(id);
    }

    @Override
    public List<EmailMessage> findAll() {
        List<EmailMessage> list = new ArrayList<>();

        emailMessageRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public void deleteById(String id) {
        emailMessageRepository.deleteById(id);
    }
}