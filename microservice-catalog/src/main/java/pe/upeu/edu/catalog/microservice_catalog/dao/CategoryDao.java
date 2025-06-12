package pe.upeu.edu.catalog.microservice_catalog.dao;

import pe.upeu.edu.catalog.microservice_catalog.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryDao {
    Category create(Category category);
    Category update(Category category);
    void delete(Long id);
    Optional<Category> read(Long id);
    List<Category> readAll();
}
