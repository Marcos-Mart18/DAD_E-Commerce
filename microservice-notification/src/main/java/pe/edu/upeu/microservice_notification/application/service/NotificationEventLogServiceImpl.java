package pe.edu.upeu.microservice_notification.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.microservice_notification.domain.model.NotificationEventLog;
import pe.edu.upeu.microservice_notification.domain.repository.NotificationEventLogRepository;
import pe.edu.upeu.microservice_notification.domain.service.NotificationEventLogService;

@Service
@RequiredArgsConstructor
public class NotificationEventLogServiceImpl implements NotificationEventLogService {
    private final NotificationEventLogRepository eventLogRepository;

    @Override
    public void saveEventLog(NotificationEventLog log) {
        eventLogRepository.save(log);
    }
}
