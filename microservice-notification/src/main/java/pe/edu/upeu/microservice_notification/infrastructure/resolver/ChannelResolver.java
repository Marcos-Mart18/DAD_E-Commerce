package pe.edu.upeu.microservice_notification.infrastructure.resolver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.upeu.microservice_notification.domain.enums.NotificationType;
import pe.edu.upeu.microservice_notification.domain.service.ChannelConfigurationService;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class ChannelResolver {

    private final ChannelConfigurationService configService;

    public String resolveApiKey(String channelType, String provider) {
        return getFieldFromConfig(channelType, provider, "apiKey");
    }

    public String resolveFromEmail(String channelType, String provider) {
        return getFieldFromConfig(channelType, provider, "fromEmail");
    }

    private String getFieldFromConfig(String channelType, String provider, String field) {
        try {
            NotificationType type = NotificationType.valueOf(channelType.toUpperCase());

            Map<String, String> config = configService.getConfig(type, provider)
                    .orElseThrow(() -> new RuntimeException("No se encontró configuración para " + type + " y proveedor " + provider));

            if (!config.containsKey(field)) {
                throw new RuntimeException("El campo '" + field + "' no existe en la configuración.");
            }

            return config.get(field);

        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Tipo de canal inválido: " + channelType, e);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener campo '" + field + "' de la configuración", e);
        }
    }
}
