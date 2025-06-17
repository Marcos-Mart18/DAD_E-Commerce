package pe.edu.upeu.microservice_notification.domain.service;

import pe.edu.upeu.microservice_notification.domain.enums.NotificationType;
import pe.edu.upeu.microservice_notification.domain.model.ChannelConfiguration;

import java.util.Map;
import java.util.Optional;

public interface ChannelConfigurationService {
    Optional<Map<String, String>> getConfig(NotificationType channelType, String providerName);
}
