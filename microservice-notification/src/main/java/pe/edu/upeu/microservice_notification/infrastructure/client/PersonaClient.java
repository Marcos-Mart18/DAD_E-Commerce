package pe.edu.upeu.microservice_notification.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upeu.microservice_notification.api.dto.PersonaDto;
import pe.edu.upeu.microservice_notification.infrastructure.config.FeignClientConfig;

@FeignClient(name = "mscv-user", configuration = FeignClientConfig.class, url = "http://localhost:8093/personas")
public interface PersonaClient {
    @GetMapping("/{id}")
    PersonaDto getPersonaById(@PathVariable("id") Long id);
}

