package pe.edu.upeu.microservice_notification.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.microservice_notification.domain.model.UserPreferences;

import java.util.Optional;

public interface UserPreferencesRepository extends JpaRepository<UserPreferences, Long> {
    Optional<UserPreferences> findByUserId(String userId);
}
