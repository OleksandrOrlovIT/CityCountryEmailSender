package orlov.oleksandr.programming.citycountryemailsender.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@AllArgsConstructor
@Configuration
public class EmailConfig {

    private final Dotenv dotenv;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(dotenv.get("EMAIL_HOST"));
        mailSender.setPort(Integer.parseInt(dotenv.get("EMAIL_PORT")));
        mailSender.setUsername(dotenv.get("EMAIL_USERNAME"));
        mailSender.setPassword(dotenv.get("EMAIL_PASSWORD"));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
