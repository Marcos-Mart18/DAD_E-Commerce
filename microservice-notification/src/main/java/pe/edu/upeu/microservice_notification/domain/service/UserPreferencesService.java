package pe.edu.upeu.microservice_notification.domain.service;

import pe.edu.upeu.microservice_notification.domain.model.UserPreferences;

import java.util.Optional;

public interface UserPreferencesService {
    Optional<UserPreferences> getPreferencesByUserId(String userId);
}
