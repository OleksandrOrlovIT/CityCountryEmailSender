package orlov.oleksandr.programming.citycountryemailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class CityCountryEmailSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityCountryEmailSenderApplication.class, args);
    }
}
