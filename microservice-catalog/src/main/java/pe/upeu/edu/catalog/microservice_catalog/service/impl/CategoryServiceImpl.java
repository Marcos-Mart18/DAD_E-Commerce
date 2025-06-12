package pe.upeu.edu.catalog.microservice_catalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.edu.catalog.microservice_catalog.Repository.CategoryRepository;
import pe.upeu.edu.catalog.microservice_catalog.dao.CategoryDao;
import pe.upeu.edu.catalog.microservice_catalog.entities.Category;
import pe.upeu.edu.catalog.microservice_catalog.service.CategoryService;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category create(Category category) {
        return categoryDao.create(category);
    }

    @Override
    public Category update(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public void delete(Long id) {
        categoryDao.delete(id);
    }

    @Override
    public Optional<Category> read(Long id) {
        return categoryDao.read(id);
    }

    @Override
    public List<Category> readAll() {
        return categoryDao.readAll();
    }
}
