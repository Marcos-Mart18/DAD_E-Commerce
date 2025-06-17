package pe.edu.upeu.microservice_notification.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.microservice_notification.domain.enums.NotificationType;
import pe.edu.upeu.microservice_notification.domain.model.NotificationTemplate;
import pe.edu.upeu.microservice_notification.domain.repository.NotificationTemplateRepository;
import pe.edu.upeu.microservice_notification.domain.service.NotificationTemplateService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationTemplateServiceImpl implements NotificationTemplateService {
    private final NotificationTemplateRepository templateRepository;

    @Override
    public Optional<NotificationTemplate> findTemplate(String name, NotificationType type, String language) {
        return templateRepository.findByNameAndTypeAndLanguage(name, type, language);
    }
}
