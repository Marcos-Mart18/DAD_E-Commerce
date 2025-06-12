package pe.upeu.edu.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upeu.edu.inventory.entities.Movimiento;
@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
}
