package pe.upeu.edu.user.service;


import pe.upeu.edu.user.entities.Direccion;

import java.util.List;
import java.util.Optional;

public interface DireccionService {
    Direccion create(Direccion direccion);
    Direccion update(Direccion direccion);
    void delete(Long id);
    Optional<Direccion> getById(Long id);
    List<Direccion> getAll();
}
