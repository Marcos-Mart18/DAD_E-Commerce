package pe.upeu.edu.catalog.microservice_catalog.service;

import org.springframework.stereotype.Service;
import pe.upeu.edu.catalog.microservice_catalog.entities.Category;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    Category create(Category category);
    Category update(Category category);
    void delete(Long id);
    Optional<Category> read(Long id);
    List<Category> readAll();
}
