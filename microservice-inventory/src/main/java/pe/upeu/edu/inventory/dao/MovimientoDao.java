package pe.upeu.edu.inventory.dao;

import pe.upeu.edu.inventory.entities.Movimiento;

import java.util.List;
import java.util.Optional;

public interface MovimientoDao {
    Movimiento create(Movimiento movimiento);
    Movimiento update(Movimiento movimiento);
    void delete(Long Id);
    Optional<Movimiento> read(Long Id);
    List<Movimiento> readAll();
}
