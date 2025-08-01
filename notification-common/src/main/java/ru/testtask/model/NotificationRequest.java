package ru.testtask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    private String type; // SMS, EMAIL, PUSH
    private String recipient;
    private String message;
}
