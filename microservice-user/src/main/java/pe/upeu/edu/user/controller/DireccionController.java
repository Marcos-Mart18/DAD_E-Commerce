package pe.upeu.edu.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.upeu.edu.user.entities.Direccion;
import pe.upeu.edu.user.service.DireccionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/direcciones")
@RequiredArgsConstructor
public class DireccionController {
    @Autowired
    private DireccionService direccionService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<Direccion>> getAll() {
        List<Direccion> direcciones = direccionService.getAll();
        if (direcciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(direcciones);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Direccion> getById(@PathVariable("id") Long id) {
        Optional<Direccion> direccion = direccionService.getById(id);
        return direccion.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Direccion> create(@Valid @RequestBody Direccion direccion) {
        Direccion creada = direccionService.create(direccion);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Direccion> update(@PathVariable("id") Long id, @Valid @RequestBody Direccion direccion) {
        Optional<Direccion> existente = direccionService.getById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        direccion.setId(id); // asegurar que se actualiza la entidad correcta
        Direccion actualizada = direccionService.update(direccion);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Optional<Direccion> direccion = direccionService.getById(id);
        if (direccion.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        direccionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
