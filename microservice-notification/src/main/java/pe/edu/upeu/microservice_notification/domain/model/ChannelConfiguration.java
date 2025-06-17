package pe.edu.upeu.microservice_notification.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import pe.edu.upeu.microservice_notification.domain.enums.NotificationType;

@Entity
@Table(name = "channel_configurations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChannelConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType channelType; // EMAIL, SMS, etc.

    @Column(nullable = false)
    private String providerName; // Ej: "SendGrid", "Twilio", "AWS_SNS"

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(nullable = false, columnDefinition = "jsonb") // PostgreSQL
    private Object config; // JSON dinámico con claves como apiKey, url, etc.
}
