package pe.upeu.edu.catalog.microservice_catalog.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.upeu.edu.catalog.microservice_catalog.Repository.ProductImageRepository;
import pe.upeu.edu.catalog.microservice_catalog.dao.ProductImageDao;
import pe.upeu.edu.catalog.microservice_catalog.entities.ProductImage;

import java.util.List;
import java.util.Optional;
@Component
public class ProductImageDaoImpl implements ProductImageDao {
    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public ProductImage create(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public ProductImage update(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public void delete(Long id) {
        productImageRepository.deleteById(id);
    }

    @Override
    public Optional<ProductImage> read(Long id) {
        return productImageRepository.findById(id);
    }

    @Override
    public List<ProductImage> readAll() {
        return productImageRepository.findAll();
    }
}
