package pe.upeu.edu.user.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.edu.user.entities.Tarjeta;
import pe.upeu.edu.user.repository.TarjetaRepository;
import pe.upeu.edu.user.service.TarjetaService;

import java.util.List;
import java.util.Optional;
@Service
public class TarjetaServiceImpl implements TarjetaService {
    @Autowired
    private TarjetaRepository tarjetaRepository;
    @Override
    public Tarjeta create(Tarjeta tarjeta) {
        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public Tarjeta update(Tarjeta tarjeta) {
        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public void delete(Long id) {
        tarjetaRepository.deleteById(id);
    }

    @Override
    public Optional<Tarjeta> getById(Long id) {
        return tarjetaRepository.findById(id);
    }

    @Override
    public List<Tarjeta> getAll() {
        return tarjetaRepository.findAll();
    }
}
