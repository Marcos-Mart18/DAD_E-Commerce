package pe.edu.upeu.microservice_notification.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.microservice_notification.domain.model.NotificationEventLog;

public interface NotificationEventLogRepository extends JpaRepository<NotificationEventLog, Long> {
}
