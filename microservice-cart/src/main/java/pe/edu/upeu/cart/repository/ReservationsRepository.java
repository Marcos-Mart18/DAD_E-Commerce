package pe.edu.upeu.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.cart.domain.Reservations;
@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
}
