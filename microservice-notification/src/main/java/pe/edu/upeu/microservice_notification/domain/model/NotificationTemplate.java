package pe.edu.upeu.microservice_notification.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.microservice_notification.domain.enums.NotificationType;

@Entity
@Table(name = "notification_templates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // Ej: "ORDER_CONFIRMED"

    @Column(columnDefinition = "TEXT")
    private String subjectTemplate; // Puede ser null para notificaciones tipo SMS

    @Column(nullable = false, columnDefinition = "TEXT")
    private String bodyTemplate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType type; // EMAIL, SMS, etc.

    @Column(length = 10)
    private String language; // Ej: "es", "en", "pt"

}
