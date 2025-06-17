package pe.edu.upeu.microservice_notification.infrastructure.kafka.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pe.edu.upeu.microservice_notification.api.dto.NotificationEventDto;
import pe.edu.upeu.microservice_notification.api.dto.PersonaDto;
import pe.edu.upeu.microservice_notification.domain.enums.NotificationStatus;
import pe.edu.upeu.microservice_notification.domain.enums.NotificationType;
import pe.edu.upeu.microservice_notification.domain.enums.ProviderType;
import pe.edu.upeu.microservice_notification.domain.model.Notification;
import pe.edu.upeu.microservice_notification.domain.model.NotificationEventLog;
import pe.edu.upeu.microservice_notification.domain.service.*;
import pe.edu.upeu.microservice_notification.infrastructure.client.PersonaClient;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationEventListener {

    private final PersonaClient personaClient;
    private final UserPreferencesService userPreferencesService;
    private final NotificationTemplateService notificationTemplateService;
    private final NotificationService notificationService;
    private final NotificationEventLogService notificationEventLogService;

    @KafkaListener(topics = "notification-events", groupId = "notification-group")
    public void listen(NotificationEventDto event) {
        log.info("📨 Evento recibido en Kafka: {}", event);

        // 1. Obtener datos de la persona
        PersonaDto persona = personaClient.getPersonaById(event.getPersonaId());
        String fullName = persona.getNombres() + " " + persona.getApellidos();

        // 2. Definir correo destino (hasta que Persona tenga el campo real)
        String recipientEmail = event.getRecipient(); // o algún correo fijo de prueba

        // 3. Validar preferencias del usuario
        userPreferencesService.getPreferencesByUserId(event.getPersonaId().toString()).ifPresent(prefs -> {
            ProviderType provider = mapProvider(event.getProvider());
            if (provider == ProviderType.GMAIL && !prefs.isEmailEnabled()) return;
            if (provider == ProviderType.TWILIO && !prefs.isSmsEnabled()) return;
        });

        // 4. Definir tipo de notificación
        NotificationType type = NotificationType.EMAIL;
        ProviderType provider = mapProvider(event.getProvider());

        // 5. Buscar plantilla
        var templateOpt = notificationTemplateService.findTemplate(
                event.getTemplateName(), type, event.getLanguage());

        if (templateOpt.isEmpty()) {
            log.warn("⚠️ No se encontró plantilla para '{}'", event.getTemplateName());
            return;
        }

        var template = templateOpt.get();
        String personalizedMessage = template.getBodyTemplate().replace("{{nombre}}", fullName);

        // 6. Crear notificación
        Notification notification = Notification.builder()
                .recipient(recipientEmail)
                .type(type)
                .provider(provider)
                .subject(template.getSubjectTemplate())
                .message(personalizedMessage)
                .status(NotificationStatus.PENDING)
                .build();

        // 7. Enviar notificación
        notificationService.sendNotification(notification);

        // 8. Guardar log del evento
        NotificationEventLog logEntry = NotificationEventLog.builder()
                .eventType(event.getEventType())
                .referenceId(event.getReferenceId())
                .notification(notification)
                .build();

        notificationEventLogService.saveEventLog(logEntry);
        log.info("✅ Notificación procesada y log guardado.");
    }

    private ProviderType mapProvider(String rawProvider) {
        if (rawProvider == null) return ProviderType.GMAIL;

        return switch (rawProvider.toUpperCase()) {
            case "SENDGRID", "GMAIL" -> ProviderType.GMAIL;
            case "TWILIO" -> ProviderType.TWILIO;
            default -> throw new IllegalArgumentException("❌ Proveedor no soportado: " + rawProvider);
        };
    }
}
