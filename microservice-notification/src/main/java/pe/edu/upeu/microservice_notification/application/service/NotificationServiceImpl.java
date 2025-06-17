package pe.edu.upeu.microservice_notification.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.microservice_notification.domain.enums.NotificationStatus;
import pe.edu.upeu.microservice_notification.domain.model.Notification;
import pe.edu.upeu.microservice_notification.domain.repository.NotificationRepository;
import pe.edu.upeu.microservice_notification.domain.service.NotificationService;
import pe.edu.upeu.microservice_notification.infrastructure.mail.EmailSenderAdapter;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final EmailSenderAdapter emailSenderAdapter;

    @Override
    public void sendNotification(Notification notification) {
        try {
            if (notification.getType().name().equalsIgnoreCase("EMAIL")) {
                emailSenderAdapter.send(notification);
            } else {
                throw new UnsupportedOperationException("🚫 Canal de envío no soportado: " + notification.getType());
            }

            notification.setStatus(NotificationStatus.SENT);
            notification.setSentAt(java.time.LocalDateTime.now());

        } catch (Exception e) {
            notification.setStatus(NotificationStatus.FAILED);
            notification.setErrorMessage(e.getMessage());
        }

        notificationRepository.save(notification);
    }

    @Override
    public Notification findById(UUID id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("❌ Notificación no encontrada"));
    }

    @Override
    public void retryNotification(UUID id) {
        Notification notification = findById(id);
        if (notification.getStatus() == NotificationStatus.FAILED) {
            notification.setAttempts(notification.getAttempts() + 1);
            sendNotification(notification);
        }
    }

    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

}
