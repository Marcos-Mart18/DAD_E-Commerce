package pe.upeu.edu.catalog.microservice_catalog.service.impl;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.edu.catalog.microservice_catalog.Repository.ProductRepository;
import pe.upeu.edu.catalog.microservice_catalog.dao.ProductDao;
import pe.upeu.edu.catalog.microservice_catalog.entities.Product;
import pe.upeu.edu.catalog.microservice_catalog.service.ProductService;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public void delete(Long id) {
        productDao.delete(id);
    }

    @Override
    public Optional<Product> read(Long id) {
        return productDao.read(id);
    }

    @Override
    public List<Product> readAll() {
        return productDao.readAll();
    }
}
