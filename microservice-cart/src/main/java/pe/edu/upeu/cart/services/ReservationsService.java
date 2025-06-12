package pe.edu.upeu.cart.services;

import pe.edu.upeu.cart.domain.Discount;
import pe.edu.upeu.cart.domain.Reservations;

import java.util.List;
import java.util.Optional;

public interface ReservationsService {
    Reservations create(Reservations reservations);
    Reservations update(Reservations reservations);
    void delete(Long reservations);
    Optional<Reservations> getById(Long id);
    List<Reservations> getAll();
}
