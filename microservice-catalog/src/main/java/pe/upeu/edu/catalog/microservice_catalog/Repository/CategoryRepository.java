package pe.upeu.edu.catalog.microservice_catalog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upeu.edu.catalog.microservice_catalog.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
