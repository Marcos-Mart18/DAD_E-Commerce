package pe.upeu.edu.catalog.microservice_catalog.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.upeu.edu.catalog.microservice_catalog.Repository.CategoryRepository;
import pe.upeu.edu.catalog.microservice_catalog.dao.CategoryDao;
import pe.upeu.edu.catalog.microservice_catalog.entities.Category;
import pe.upeu.edu.catalog.microservice_catalog.service.CategoryService;

import java.util.List;
import java.util.Optional;
@Component
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private CategoryRepository CategoryRepository;

    @Override
    public Category create(Category category) {
        return CategoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return CategoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        CategoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> read(Long id) {
        return CategoryRepository.findById(id);
    }

    @Override
    public List<Category> readAll() {
        return CategoryRepository.findAll();
    }
}
