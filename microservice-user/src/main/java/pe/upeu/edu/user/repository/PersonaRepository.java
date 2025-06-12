package pe.upeu.edu.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upeu.edu.user.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
