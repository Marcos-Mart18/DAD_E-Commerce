package pe.edu.upeu.microservice_notification.domain.enums;

public enum NotificationType {
    EMAIL,
    SMS,
    PUSH,
    WHATSAPP;  // Ejemplo de extensión futura

    // Opcional: Métodos útiles
    public boolean isEmail() {
        return this == EMAIL;
    }
}
