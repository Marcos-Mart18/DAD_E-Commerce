package pe.upeu.edu.inventory.service;

import pe.upeu.edu.inventory.dto.ProductDTO;
import pe.upeu.edu.inventory.entities.Inventario;

import java.util.List;
import java.util.Optional;

public interface InventarioService{
    Inventario create(Inventario inventario);
    Inventario update(Inventario inventario);
    void delete(Long Id);
    Optional<Inventario> read(Long Id);
    List<Inventario> readAll();
    ProductDTO obtenerProductoPorId(Long idProducto);
}
