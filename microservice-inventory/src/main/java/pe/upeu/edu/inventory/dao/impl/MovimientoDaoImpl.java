package pe.upeu.edu.inventory.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pe.upeu.edu.inventory.dao.MovimientoDao;
import pe.upeu.edu.inventory.entities.Movimiento;
import pe.upeu.edu.inventory.service.MovimientoService;

import java.util.List;
import java.util.Optional;

public class MovimientoDaoImpl implements MovimientoDao {
    @Autowired
    private MovimientoService movimientoService;
    @Override
    public Movimiento create(Movimiento movimiento) {
        return movimientoService.create(movimiento);
    }

    @Override
    public Movimiento update(Movimiento movimiento) {
        return movimientoService.update(movimiento);
    }

    @Override
    public void delete(Long Id) {
        movimientoService.delete(Id);
    }

    @Override
    public Optional<Movimiento> read(Long Id) {
        return movimientoService.read(Id);
    }

    @Override
    public List<Movimiento> readAll() {
        return movimientoService.readAll();
    }
}
