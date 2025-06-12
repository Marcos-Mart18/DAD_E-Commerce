package pe.upeu.edu.inventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.edu.inventory.entities.Movimiento;
import pe.upeu.edu.inventory.repository.MovimientoRepository;
import pe.upeu.edu.inventory.service.MovimientoService;

import java.util.List;
import java.util.Optional;
@Service
public class MovimientoServiceImpl implements MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;
    @Override
    public Movimiento create(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public Movimiento update(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public void delete(Long Id) {
        movimientoRepository.deleteById(Id);
    }

    @Override
    public Optional<Movimiento> read(Long Id) {
        return movimientoRepository.findById(Id);
    }

    @Override
    public List<Movimiento> readAll() {
        return movimientoRepository.findAll();
    }
}
