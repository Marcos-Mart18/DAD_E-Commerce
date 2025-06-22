package pe.upeu.edu.admin_panel.microservice_admin_panel.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.ProductoDTO;

import java.util.List;

@FeignClient(name = "msvc-catalog", contextId = "productoClient", path = "/productos")
public interface ProductClient {
    @GetMapping
    List<ProductoDTO> getAllProducts();

    @GetMapping("/{id}")
    ProductoDTO getProductById(@PathVariable("id") Long id);

    @PostMapping
    ProductoDTO createProduct(@RequestBody ProductoDTO productoDTO);

    @PutMapping("/{id}")
    ProductoDTO updateProduct(@PathVariable("id") Long id, @RequestBody ProductoDTO productoDTO);

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable("id") Long id);
}
