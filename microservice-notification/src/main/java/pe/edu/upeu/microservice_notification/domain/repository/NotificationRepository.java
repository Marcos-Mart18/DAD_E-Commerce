package pe.edu.upeu.microservice_notification.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.microservice_notification.domain.model.Notification;

import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {
}
