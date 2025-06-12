package pe.upeu.edu.user.service;

import pe.upeu.edu.user.entities.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    Persona create(Persona persona);
    Persona update(Persona persona);
    void delete(Long id);
    Optional<Persona> getById(Long id);
    List<Persona> getAll();
}
