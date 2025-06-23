package pe.upeu.edu.catalog.microservice_catalog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upeu.edu.catalog.microservice_catalog.entities.ProductDescription;
@Repository
public interface ProductDescriptionRepository extends JpaRepository<ProductDescription, Long> {
}
