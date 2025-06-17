    package pe.edu.upeu.microservice_notification.api.mapper;

    import org.mapstruct.Mapper;
    import pe.edu.upeu.microservice_notification.api.dto.NotificationDto;
    import pe.edu.upeu.microservice_notification.api.dto.NotificationEventDto;
    import pe.edu.upeu.microservice_notification.domain.enums.NotificationType;
    import pe.edu.upeu.microservice_notification.domain.enums.ProviderType;
    import pe.edu.upeu.microservice_notification.domain.model.Notification;

    @Mapper(componentModel = "spring")
    public interface NotificationMapper {
        NotificationDto toDto(Notification notification);

        // Conversión manual del evento Kafka al modelo Notification
        default Notification fromEventDto(NotificationEventDto dto) {
            Notification notification = new Notification();
            notification.setRecipient(dto.getRecipient());
            notification.setSubject(dto.getTemplateName()); // o genera dinámicamente
            notification.setMessage("Contenido generado para: " + dto.getTemplateName()); // temporal

            // Asume EMAIL como tipo por defecto
            notification.setType(NotificationType.EMAIL);

            // Mapea el provider (SendGrid → GMAIL)
            notification.setProvider(mapProvider(dto.getProvider()));

            return notification;
        }

        // Mapear el texto del provider al enum correcto
        private ProviderType mapProvider(String providerStr) {
            if (providerStr == null) return ProviderType.GMAIL;
            return switch (providerStr.toUpperCase()) {
                case "SENDGRID" -> ProviderType.GMAIL; // Ya migraste a Gmail
                case "GMAIL" -> ProviderType.GMAIL;
                case "TWILIO" -> ProviderType.TWILIO;  // si piensas soportarlo después
                default -> throw new IllegalArgumentException("Proveedor no soportado: " + providerStr);
            };
        }
    }
