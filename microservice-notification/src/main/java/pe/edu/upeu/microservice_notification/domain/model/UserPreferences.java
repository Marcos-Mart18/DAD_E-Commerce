package pe.edu.upeu.microservice_notification.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_preferences")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private boolean emailEnabled;

    @Column(nullable = false)
    private boolean smsEnabled;

    @Column(nullable = false)
    private boolean pushEnabled;

    @Column(length = 5)
    private String languagePreference;

    @Transient
    private boolean valuesSetExplicitly = false;

    @PrePersist
    public void setDefaults() {
        if (languagePreference == null) {
            languagePreference = "es";
        }
        if (!valuesSetExplicitly) {
            emailEnabled = true;
            smsEnabled = false;
            pushEnabled = true;
        }
    }
}