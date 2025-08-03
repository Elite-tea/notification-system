package ru.testtask.notification_data_collector.service;

import lombok.Getter;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.testtask.notification_data_collector.model.NotificationMetrics;
import ru.testtask.notification_data_collector.repository.MetricsRepository;

@Service
@Getter
public class NotificationValidateService {

    private final MetricsRepository metricsRepository;

    @Autowired
    public NotificationValidateService(MetricsRepository metricsRepository) {
        this.metricsRepository = metricsRepository;
    }

    public ResponseEntity<NotificationMetrics> validateNotification(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Notification type cannot be null or empty");
        }

        NotificationMetrics metrics = metricsRepository.findByType(type.toUpperCase())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Notification metrics for type '%s' not found", type.toUpperCase())));

        return ResponseEntity.ok(metrics);
    }
}
