package pe.upeu.edu.catalog.microservice_catalog.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.upeu.edu.catalog.microservice_catalog.Repository.ProductRepository;
import pe.upeu.edu.catalog.microservice_catalog.dao.ProductDao;
import pe.upeu.edu.catalog.microservice_catalog.entities.Product;

import java.util.List;
import java.util.Optional;
@Component
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> read(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> readAll() {
        return productRepository.findAll();
    }
}
