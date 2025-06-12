package pe.upeu.edu.catalog.microservice_catalog.dao;

import pe.upeu.edu.catalog.microservice_catalog.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    Product create(Product product);
    Product update(Product product);
    void delete(Long id);
    Optional<Product> read(Long id);
    List<Product> readAll();
}
