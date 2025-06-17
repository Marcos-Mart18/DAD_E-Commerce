package pe.edu.upeu.microservice_notification.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.microservice_notification.domain.model.ChannelConfiguration;
import pe.edu.upeu.microservice_notification.domain.enums.NotificationType;

import java.util.Optional;

public interface ChannelConfigurationRepository extends JpaRepository<ChannelConfiguration, Long> {
    Optional<ChannelConfiguration> findByChannelTypeAndProviderName(NotificationType channelType, String providerName);
}
