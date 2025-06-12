package pe.upeu.edu.inventory.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.upeu.edu.inventory.dao.InventarioDao;
import pe.upeu.edu.inventory.entities.Inventario;
import pe.upeu.edu.inventory.service.InventarioService;

import java.util.List;
import java.util.Optional;
@Component
public class InventarioDaoImpl implements InventarioDao{
    @Autowired
    private InventarioService inventarioService;
    @Override
    public Inventario create(Inventario inventario) {
        return inventarioService.create(inventario);
    }

    @Override
    public Inventario update(Inventario inventario) {
        return inventarioService.update(inventario);
    }

    @Override
    public void delete(Long Id) {
        inventarioService.delete(Id);
    }

    @Override
    public Optional<Inventario> read(Long Id) {
        return inventarioService.read(Id);
    }

    @Override
    public List<Inventario> readAll() {
        return inventarioService.readAll();
    }
}
