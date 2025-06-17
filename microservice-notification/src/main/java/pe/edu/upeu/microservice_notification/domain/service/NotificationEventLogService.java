package pe.edu.upeu.microservice_notification.domain.service;

import pe.edu.upeu.microservice_notification.domain.model.NotificationEventLog;

public interface NotificationEventLogService {
    void saveEventLog(NotificationEventLog log);
}
