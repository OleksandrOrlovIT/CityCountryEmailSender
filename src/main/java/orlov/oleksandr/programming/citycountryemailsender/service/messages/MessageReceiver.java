package orlov.oleksandr.programming.citycountryemailsender.service.messages;

import org.springframework.stereotype.Service;

@Service
public class MessageReceiver {

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}