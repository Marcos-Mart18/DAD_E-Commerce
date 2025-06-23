package pe.upeu.edu.catalog.microservice_catalog.dao;

import pe.upeu.edu.catalog.microservice_catalog.entities.ProductImage;

import java.util.List;
import java.util.Optional;

public interface ProductImageDao {
    ProductImage create(ProductImage productImage);
    ProductImage update(ProductImage productImage);
    void delete(Long id);
    Optional<ProductImage> read(Long id);
    List<ProductImage> readAll();
}
