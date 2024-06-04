package orlov.oleksandr.programming.citycountryemailsender.service.email;

import orlov.oleksandr.programming.citycountryemailsender.model.EmailMessage;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
    EmailMessage sendEmailMessage(EmailMessage emailMessage);
}
