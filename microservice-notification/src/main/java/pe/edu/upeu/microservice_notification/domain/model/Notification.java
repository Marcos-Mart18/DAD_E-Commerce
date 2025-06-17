package pe.edu.upeu.microservice_notification.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.microservice_notification.domain.enums.NotificationStatus;
import pe.edu.upeu.microservice_notification.domain.enums.NotificationType;
import pe.edu.upeu.microservice_notification.domain.enums.ProviderType;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String recipient; // Correo, teléfono, etc.

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType type; // EMAIL, SMS, PUSH, etc.

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProviderType provider; // SENDGRID, TWILIO, etc.

    private String subject; // Usado en emails o notificaciones enriquecidas

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationStatus status;

    @Column(nullable = false)
    private int attempts;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime sentAt;

    private String errorMessage;

    // Ejemplo de relación uno a uno (puedes eliminarla si no usas logs)
    @OneToOne(mappedBy = "notification", cascade = CascadeType.ALL)
    private NotificationEventLog eventLog;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        if (status == null) status = NotificationStatus.PENDING;
        if (attempts == 0) attempts = 0;
    }
}
