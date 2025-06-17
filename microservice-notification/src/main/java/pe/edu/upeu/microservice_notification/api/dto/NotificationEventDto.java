package pe.edu.upeu.microservice_notification.api.dto;

import lombok.Data;

@Data
public class NotificationEventDto {
    private Long idPersona;
    private String eventType;     // Ej: "ORDER_CONFIRMED"
    private Long personaId;       // ← ID para consultar vía Feign
    private String templateName;  // Nombre del template a usar
    private String language;      // Ej: "es", "en"
    private String provider;      // Ej: "GMAIL", "SendGrid"
    private String referenceId;   // ID de entidad relacionada
    private String recipient;  // correo del destinatario
}
