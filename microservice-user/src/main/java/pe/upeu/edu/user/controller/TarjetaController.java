package pe.upeu.edu.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.upeu.edu.user.entities.Tarjeta;
import pe.upeu.edu.user.service.TarjetaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarjetas")
@RequiredArgsConstructor
public class TarjetaController {
    @Autowired
    private TarjetaService tarjetaService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<Tarjeta>> getAll() {
        List<Tarjeta> tarjetas = tarjetaService.getAll();
        if (tarjetas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tarjetas);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Tarjeta> getById(@PathVariable("id") Long id) {
        Optional<Tarjeta> tarjeta = tarjetaService.getById(id);
        return tarjeta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Tarjeta> create(@Valid @RequestBody Tarjeta tarjeta) {
        Tarjeta creada = tarjetaService.create(tarjeta);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Tarjeta> update(@PathVariable("id") Long id, @Valid @RequestBody Tarjeta tarjeta) {
        Optional<Tarjeta> existente = tarjetaService.getById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        tarjeta.setId(id);
        Tarjeta actualizada = tarjetaService.update(tarjeta);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Optional<Tarjeta> tarjeta = tarjetaService.getById(id);
        if (tarjeta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        tarjetaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
