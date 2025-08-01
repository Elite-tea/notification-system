package ru.testtask.notification_data_collector.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "notification_metrics")
public class NotificationMetrics {
    @Id
    private String id;
    private String type;
    private long count;
    private LocalDateTime lastUpdated;
}
