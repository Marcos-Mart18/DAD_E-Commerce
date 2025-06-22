package pe.upeu.edu.admin_panel.microservice_admin_panel.service;

import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.ProductoDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductoDTO createProduct(ProductoDTO producto);
    ProductoDTO updateProduct(ProductoDTO producto);
    void deleteProduct(Long id);
    ProductoDTO getProductById(Long id);
    List<ProductoDTO> getAllProducts();

}
