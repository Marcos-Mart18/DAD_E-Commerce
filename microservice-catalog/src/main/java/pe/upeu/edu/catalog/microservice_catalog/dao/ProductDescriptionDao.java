package pe.upeu.edu.catalog.microservice_catalog.dao;

import pe.upeu.edu.catalog.microservice_catalog.entities.ProductDescription;

import java.util.List;
import java.util.Optional;

public interface ProductDescriptionDao {
    ProductDescription create(ProductDescription productDescription);
    ProductDescription update(ProductDescription productDescription);
    void delete(Long id);
    Optional<ProductDescription> read(Long id);
    List<ProductDescription> readAll();
}
