package pe.upeu.edu.catalog.microservice_catalog.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.upeu.edu.catalog.microservice_catalog.Repository.ProductDescriptionRepository;
import pe.upeu.edu.catalog.microservice_catalog.dao.ProductDescriptionDao;
import pe.upeu.edu.catalog.microservice_catalog.entities.ProductDescription;

import java.util.List;
import java.util.Optional;
@Component
public class ProductDescriptionDaoImpl implements ProductDescriptionDao {
    @Autowired
    private ProductDescriptionRepository productDescriptionRepository;

    @Override
    public ProductDescription create(ProductDescription productDescription) {
        return productDescriptionRepository.save(productDescription);
    }

    @Override
    public ProductDescription update(ProductDescription productDescription) {
        return productDescriptionRepository.save(productDescription);
    }

    @Override
    public void delete(Long id) {
        productDescriptionRepository.deleteById(id);
    }

    @Override
    public Optional<ProductDescription> read(Long id) {
        return productDescriptionRepository.findById(id);
    }

    @Override
    public List<ProductDescription> readAll() {
        return productDescriptionRepository.findAll();
    }
}
