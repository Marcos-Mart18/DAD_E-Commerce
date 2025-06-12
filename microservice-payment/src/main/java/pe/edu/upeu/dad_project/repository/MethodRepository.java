package pe.edu.upeu.dad_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.dad_project.domain.Method;

@Repository
public interface MethodRepository extends JpaRepository<Method,Long> {
}
