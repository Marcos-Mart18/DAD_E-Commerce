package pe.edu.upeu.microservice_notification.domain.service;

import pe.edu.upeu.microservice_notification.domain.enums.NotificationType;
import pe.edu.upeu.microservice_notification.domain.model.NotificationTemplate;

import java.util.Optional;

public interface NotificationTemplateService {
    Optional<NotificationTemplate> findTemplate(String name, NotificationType type, String language);
}
