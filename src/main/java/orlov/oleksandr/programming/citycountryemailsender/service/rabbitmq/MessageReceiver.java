package orlov.oleksandr.programming.citycountryemailsender.service.rabbitmq;

public interface MessageReceiver {
    void receiveMessage(String message);
}
