package pe.upeu.edu.inventory.dao;

import pe.upeu.edu.inventory.entities.Inventario;

import java.util.List;
import java.util.Optional;

public interface InventarioDao {
    Inventario create(Inventario inventario);
    Inventario update(Inventario inventario);
    void delete(Long Id);
    Optional<Inventario> read(Long Id);
    List<Inventario> readAll();
}
