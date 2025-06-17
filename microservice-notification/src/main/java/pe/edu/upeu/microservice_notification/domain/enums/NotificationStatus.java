package pe.edu.upeu.microservice_notification.domain.enums;

public enum NotificationStatus {
    PENDING,
    SENT,
    FAILED,
    DELIVERED;  // Nuevo estado posible

    public boolean isFinalState() {
        return this == SENT || this == FAILED || this == DELIVERED;
    }
}
