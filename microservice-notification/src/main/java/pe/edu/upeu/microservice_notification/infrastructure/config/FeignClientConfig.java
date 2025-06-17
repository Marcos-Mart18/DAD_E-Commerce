package pe.edu.upeu.microservice_notification.infrastructure.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignClientConfig {
    @Bean
    public RequestInterceptor keycloakFeignInterceptor() {
        return new KeycloakFeignInterceptor();
    }
}
