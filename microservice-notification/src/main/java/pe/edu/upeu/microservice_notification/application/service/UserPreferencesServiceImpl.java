package pe.edu.upeu.microservice_notification.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.microservice_notification.domain.model.UserPreferences;
import pe.edu.upeu.microservice_notification.domain.repository.UserPreferencesRepository;
import pe.edu.upeu.microservice_notification.domain.service.UserPreferencesService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserPreferencesServiceImpl implements UserPreferencesService {
    private final UserPreferencesRepository preferencesRepository;

    @Override
    public Optional<UserPreferences> getPreferencesByUserId(String userId) {
        return preferencesRepository.findByUserId(userId);
    }
}
