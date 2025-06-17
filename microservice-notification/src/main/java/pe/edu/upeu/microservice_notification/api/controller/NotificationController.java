package pe.edu.upeu.microservice_notification.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.microservice_notification.api.dto.NotificationDto;
import pe.edu.upeu.microservice_notification.api.mapper.NotificationMapper;
import pe.edu.upeu.microservice_notification.domain.service.NotificationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    private final NotificationMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDto> getById(@PathVariable UUID id) {
        var notification = notificationService.findById(id);
        return ResponseEntity.ok(mapper.toDto(notification));
    }

    @PostMapping("/{id}/retry")
    public ResponseEntity<Void> retryNotification(@PathVariable UUID id) {
        notificationService.retryNotification(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<NotificationDto>> getAll() {
        var all = notificationService.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
        return ResponseEntity.ok(all);
    }

}
