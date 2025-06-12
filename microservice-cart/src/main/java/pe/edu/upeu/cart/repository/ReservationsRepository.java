package pe.edu.upeu.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.cart.domain.Reservations;

public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
}
