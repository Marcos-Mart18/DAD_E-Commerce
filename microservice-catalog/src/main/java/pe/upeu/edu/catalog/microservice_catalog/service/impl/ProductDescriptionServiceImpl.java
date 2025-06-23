package pe.upeu.edu.catalog.microservice_catalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.edu.catalog.microservice_catalog.dao.ProductDescriptionDao;
import pe.upeu.edu.catalog.microservice_catalog.entities.ProductDescription;
import pe.upeu.edu.catalog.microservice_catalog.service.ProductDescriptionService;

import java.util.List;
import java.util.Optional;
@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {
    @Autowired
    private ProductDescriptionDao productDescriptionDao;

    @Override
    public ProductDescription create(ProductDescription productDescription) {
        return productDescriptionDao.create(productDescription);
    }

    @Override
    public ProductDescription update(ProductDescription productDescription) {
        return productDescriptionDao.update(productDescription);
    }

    @Override
    public void delete(Long id) {
        productDescriptionDao.delete(id);
    }

    @Override
    public Optional<ProductDescription> read(Long id) {
        return productDescriptionDao.read(id);
    }

    @Override
    public List<ProductDescription> readAll() {
        return productDescriptionDao.readAll();
    }
}
