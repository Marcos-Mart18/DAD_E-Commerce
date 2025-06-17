package pe.edu.upeu.microservice_notification.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.microservice_notification.domain.enums.NotificationType;
import pe.edu.upeu.microservice_notification.domain.model.NotificationTemplate;

import java.util.Optional;

public interface NotificationTemplateRepository extends JpaRepository<NotificationTemplate, Long> {
    Optional<NotificationTemplate> findByNameAndTypeAndLanguage(String name, NotificationType type, String language);
}
