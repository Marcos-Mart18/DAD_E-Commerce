package pe.edu.upeu.microservice_notification.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification_event_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationEventLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String eventType; // Ej: "ORDER_PLACED"

    private String referenceId; // ID relacionado al evento (pedido, usuario, etc.)

    @Column(nullable = false)
    private LocalDateTime triggeredAt;

    @OneToOne
    @JoinColumn(name = "notification_id", nullable = false, unique = true)
    private Notification notification;

    @PrePersist
    public void prePersist() {
        if (triggeredAt == null) {
            triggeredAt = LocalDateTime.now();
        }
    }
}
