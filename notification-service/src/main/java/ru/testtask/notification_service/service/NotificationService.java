package ru.testtask.notification_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.testtask.model.NotificationRequest;

@Service
public class NotificationService {

    private final KafkaTemplate<String, NotificationRequest> kafkaTemplate;

    @Value("${notification.topics.sms}")
    private String smsTopic;

    @Value("${notification.topics.email}")
    private String emailTopic;

    @Value("${notification.topics.push}")
    private String pushTopic;

    @Autowired
    public NotificationService(KafkaTemplate<String, NotificationRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(NotificationRequest request) {
        String topic = switch (request.getType().toUpperCase()) {
            case "SMS" -> smsTopic;
            case "EMAIL" -> emailTopic;
            case "PUSH" -> pushTopic;
            default -> throw new IllegalArgumentException("Invalid notification type: " + request.getType());
        };

        kafkaTemplate.send(topic, request);
    }
}
