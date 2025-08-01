package ru.testtask.notification_data_collector.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.testtask.notification_data_collector.model.NotificationMetrics;

import java.util.Optional;

public interface MetricsRepository extends MongoRepository<NotificationMetrics, String> {
    Optional<NotificationMetrics> findByType(String type);
}