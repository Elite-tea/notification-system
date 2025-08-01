package ru.testtask.notification_data_collector.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.testtask.model.NotificationRequest;
import ru.testtask.notification_data_collector.model.NotificationMetrics;
import ru.testtask.notification_data_collector.repository.MetricsRepository;


import java.time.LocalDateTime;

@Service
public class NotificationConsumer {

    private final MetricsRepository metricsRepository;

    @Autowired
    public NotificationConsumer(MetricsRepository metricsRepository) {
        this.metricsRepository = metricsRepository;
    }

    @KafkaListener(topics = "notifications.sms")
    public void consumeSms(NotificationRequest request) {
        updateMetrics("SMS");
    }

    @KafkaListener(topics = "notifications.email")
    public void consumeEmail(NotificationRequest request) {
        updateMetrics("EMAIL");
    }

    @KafkaListener(topics = "notifications.push")
    public void consumePush(NotificationRequest request) {
        updateMetrics("PUSH");
    }

    private void updateMetrics(String type) {
        metricsRepository.findByType(type)
                .ifPresentOrElse(
                        metrics -> {
                            metrics.setCount(metrics.getCount() + 1);
                            metrics.setLastUpdated(LocalDateTime.now());
                            metricsRepository.save(metrics);
                        },
                        () -> {
                            NotificationMetrics newMetrics = new NotificationMetrics();
                            newMetrics.setType(type);
                            newMetrics.setCount(1);
                            newMetrics.setLastUpdated(LocalDateTime.now());
                            metricsRepository.save(newMetrics);
                        }
                );
    }
}
