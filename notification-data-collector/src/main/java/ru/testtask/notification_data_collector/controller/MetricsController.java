package ru.testtask.notification_data_collector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.testtask.notification_data_collector.model.NotificationMetrics;
import ru.testtask.notification_data_collector.repository.MetricsRepository;
import ru.testtask.notification_data_collector.service.NotificationValidateService;

import java.util.List;

@RestController
@RequestMapping("/api/metrics")
public class MetricsController {

    private final MetricsRepository metricsRepository;
    private final NotificationValidateService notificationValidateService;

    @Autowired
    public MetricsController(MetricsRepository metricsRepository, NotificationValidateService notificationValidateService) {
        this.metricsRepository = metricsRepository;
        this.notificationValidateService = notificationValidateService;
    }

    @GetMapping
    public ResponseEntity<List<NotificationMetrics>> getAllMetrics() {
        return ResponseEntity.ok(notificationValidateService.getMetricsRepository().findAll());
    }

    @GetMapping("/{type}")
    public ResponseEntity<NotificationMetrics> getMetricsByType(@PathVariable String type) {
        return notificationValidateService.validateNotification(type);
    }
}