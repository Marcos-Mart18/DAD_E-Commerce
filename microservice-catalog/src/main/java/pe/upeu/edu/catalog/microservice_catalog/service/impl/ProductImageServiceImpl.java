package pe.upeu.edu.catalog.microservice_catalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.edu.catalog.microservice_catalog.dao.ProductImageDao;
import pe.upeu.edu.catalog.microservice_catalog.entities.ProductImage;
import pe.upeu.edu.catalog.microservice_catalog.service.ProductImageService;

import java.util.List;
import java.util.Optional;
@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    private ProductImageDao productImageDao;

    @Override
    public ProductImage create(ProductImage productImage) {
        return productImageDao.create(productImage);
    }

    @Override
    public ProductImage update(ProductImage productImage) {
        return productImageDao.update(productImage);
    }

    @Override
    public void delete(Long id) {
        productImageDao.delete(id);
    }

    @Override
    public Optional<ProductImage> read(Long id) {
        return productImageDao.read(id);
    }

    @Override
    public List<ProductImage> readAll() {
        return productImageDao.readAll();
    }
}
