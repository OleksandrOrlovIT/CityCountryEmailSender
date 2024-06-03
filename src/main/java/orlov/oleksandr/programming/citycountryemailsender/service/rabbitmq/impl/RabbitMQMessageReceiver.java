package orlov.oleksandr.programming.citycountryemailsender.service.rabbitmq.impl;

import org.springframework.stereotype.Service;
import orlov.oleksandr.programming.citycountryemailsender.service.rabbitmq.MessageReceiver;

@Service
public class RabbitMQMessageReceiver implements MessageReceiver {

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}