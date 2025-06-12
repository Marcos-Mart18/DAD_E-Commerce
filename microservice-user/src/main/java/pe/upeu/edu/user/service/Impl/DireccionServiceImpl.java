package pe.upeu.edu.user.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.edu.user.entities.Direccion;
import pe.upeu.edu.user.repository.DireccionRepository;
import pe.upeu.edu.user.service.DireccionService;

import java.util.List;
import java.util.Optional;
@Service
public class DireccionServiceImpl implements DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;
    @Override
    public Direccion create(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public Direccion update(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public void delete(Long id) {
        direccionRepository.deleteById(id);
    }

    @Override
    public Optional<Direccion> getById(Long id) {
        return direccionRepository.findById(id);
    }

    @Override
    public List<Direccion> getAll() {
        return direccionRepository.findAll();
    }
}
