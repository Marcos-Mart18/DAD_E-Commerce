package pe.upeu.edu.user.service;


import pe.upeu.edu.user.entities.Tarjeta;

import java.util.List;
import java.util.Optional;

public interface TarjetaService {
    Tarjeta create(Tarjeta tarjeta);
    Tarjeta update(Tarjeta tarjeta);
    void delete(Long id);
    Optional<Tarjeta> getById(Long id);
    List<Tarjeta> getAll();
}
