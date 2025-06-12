package pe.upeu.edu.catalog.microservice_catalog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upeu.edu.catalog.microservice_catalog.entities.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
