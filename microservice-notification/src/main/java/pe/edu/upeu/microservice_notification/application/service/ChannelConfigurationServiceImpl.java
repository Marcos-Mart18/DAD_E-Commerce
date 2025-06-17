package pe.edu.upeu.microservice_notification.application.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.microservice_notification.domain.enums.NotificationType;
import pe.edu.upeu.microservice_notification.domain.model.ChannelConfiguration;
import pe.edu.upeu.microservice_notification.domain.repository.ChannelConfigurationRepository;
import pe.edu.upeu.microservice_notification.domain.service.ChannelConfigurationService;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChannelConfigurationServiceImpl implements ChannelConfigurationService {
    private final ChannelConfigurationRepository configurationRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Optional<Map<String, String>> getConfig(NotificationType channelType, String providerName) {
        return configurationRepository
                .findByChannelTypeAndProviderName(channelType, providerName)
                .map(ChannelConfiguration::getConfig)
                .map(configObj -> objectMapper.convertValue(
                        configObj, new TypeReference<Map<String, String>>() {}));
    }
}
