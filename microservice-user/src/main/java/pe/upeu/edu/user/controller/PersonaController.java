package pe.upeu.edu.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.upeu.edu.user.entities.Persona;

import jakarta.validation.Valid;
import pe.upeu.edu.user.service.PersonaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;


    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<Persona>> getAll() {
        List<Persona> personas = personaService.getAll();
        if (personas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id) {
        Optional<Persona> persona = personaService.getById(id);
        return persona.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Persona> create(@Valid @RequestBody Persona persona) {
        Persona creada = personaService.create(persona);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Persona persona) {
        Optional<Persona> existente = personaService.getById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        persona.setIdPersona(id);
        Persona actualizada = personaService.update(persona);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Optional<Persona> persona = personaService.getById(id);
        if (persona.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        personaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
