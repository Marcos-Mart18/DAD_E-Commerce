package pe.upeu.edu.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upeu.edu.user.entities.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}
