package ru.testtask.notification_data_collector.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.testtask.model.NotificationRequest;
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
        try {
            return metricsRepository.findByType(type)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
