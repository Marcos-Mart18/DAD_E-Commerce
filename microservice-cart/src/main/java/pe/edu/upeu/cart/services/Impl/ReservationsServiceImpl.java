package pe.edu.upeu.cart.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.cart.domain.Item;
import pe.edu.upeu.cart.domain.Reservations;
import pe.edu.upeu.cart.repository.ItemRepository;
import pe.edu.upeu.cart.repository.ReservationsRepository;
import pe.edu.upeu.cart.services.ReservationsService;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationsServiceImpl  implements ReservationsService {

    @Autowired
    public ReservationsRepository reservationsRepository;

    @Override
    public Reservations create(Reservations reservations) {return reservationsRepository.save(reservations);}

    @Override
    public Reservations update(Reservations reservations) {
        return reservationsRepository.save(reservations);
    }

    @Override
    public void delete(Long id) {reservationsRepository.deleteById(id);}

    @Override
    public Optional<Reservations> getById(Long id) {
        return reservationsRepository.findById(id);
    }

    @Override
    public List<Reservations> getAll() {
        return reservationsRepository.findAll();
    }
}
