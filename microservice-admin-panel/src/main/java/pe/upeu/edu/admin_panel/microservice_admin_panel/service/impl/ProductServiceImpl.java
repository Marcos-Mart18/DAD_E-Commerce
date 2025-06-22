package pe.upeu.edu.admin_panel.microservice_admin_panel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.upeu.edu.admin_panel.microservice_admin_panel.client.ProductClient;
import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.ProductoDTO;
import pe.upeu.edu.admin_panel.microservice_admin_panel.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductClient productClient;

    @Override
    public ProductoDTO createProduct(ProductoDTO producto) {
        return productClient.createProduct(producto);
    }

    @Override
    public ProductoDTO updateProduct(ProductoDTO producto) {
        return productClient.updateProduct(producto.getId(), producto);
    }

    @Override
    public void deleteProduct(Long id) {
        productClient.deleteProduct(id);
    }

    @Override
    public ProductoDTO getProductById(Long id) {
        return productClient.getProductById(id);
    }

    @Override
    public List<ProductoDTO> getAllProducts() {
        return productClient.getAllProducts();
    }
}
