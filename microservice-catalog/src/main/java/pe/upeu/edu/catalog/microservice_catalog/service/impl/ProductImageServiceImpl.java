package pe.upeu.edu.catalog.microservice_catalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.edu.catalog.microservice_catalog.entities.ProductImage;
import pe.upeu.edu.catalog.microservice_catalog.service.ProductImageService;

import java.util.List;
import java.util.Optional;
@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    private ProductImageService productImageService;

    @Override
    public ProductImage create(ProductImage productImage) {
        return productImageService.create(productImage);
    }

    @Override
    public ProductImage update(ProductImage productImage) {
        return productImageService.update(productImage);
    }

    @Override
    public void delete(Long id) {
        productImageService.delete(id);
    }

    @Override
    public Optional<ProductImage> read(Long id) {
        return productImageService.read(id);
    }

    @Override
    public List<ProductImage> readAll() {
        return productImageService.readAll();
    }
}
