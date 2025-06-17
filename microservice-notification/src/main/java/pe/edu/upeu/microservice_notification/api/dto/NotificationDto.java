package pe.edu.upeu.microservice_notification.api.dto;

import lombok.Data;
import pe.edu.upeu.microservice_notification.domain.enums.NotificationStatus;
import pe.edu.upeu.microservice_notification.domain.enums.NotificationType;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class NotificationDto {
    private UUID id;
    private String recipient;
    private NotificationType type;
    private String subject;
    private String message;
    private NotificationStatus status;
    private int attempts;
    private LocalDateTime createdAt;
    private LocalDateTime sentAt;
}
