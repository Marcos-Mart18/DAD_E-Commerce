package pe.upeu.edu.catalog.microservice_catalog.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.edu.catalog.microservice_catalog.entities.Category;
import pe.upeu.edu.catalog.microservice_catalog.entities.Product;
import pe.upeu.edu.catalog.microservice_catalog.service.CategoryService;
import pe.upeu.edu.catalog.microservice_catalog.service.ProductService;

import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> products = productService.readAll();
            if (products.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener los productos: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        try {
            Product product = productService.read(id).orElse(null);
            if (product == null) {
                return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener el producto: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product) {
        try {
            if (product.getCategory() == null || product.getCategory().getId() == null) {
                return new ResponseEntity<>("La categoría es obligatoria", HttpStatus.BAD_REQUEST);
            }
            Category category = categoryService.read(product.getCategory().getId()).orElse(null);
            if (category == null) {
                return new ResponseEntity<>("Categoría no encontrada", HttpStatus.BAD_REQUEST);
            }

            product.setCategory(category);

            Product createdProduct = productService.create(product);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al guardar producto: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long id, @Valid @RequestBody Product product) {
        try {
            if (!productService.read(id).isPresent()) {
                return ResponseEntity.notFound().build();
            }

            if (product.getCategory() == null || product.getCategory().getId() == null) {
                return new ResponseEntity<>("La categoría es obligatoria", HttpStatus.BAD_REQUEST);
            }

            Category category = categoryService.read(product.getCategory().getId()).orElse(null);
            if (category == null) {
                return new ResponseEntity<>("Categoría no encontrada", HttpStatus.BAD_REQUEST);
            }

            product.setCategory(category);
            product.setId(id);

            Product updatedProduct = productService.update(product);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception e) {
            log.error("Error al actualizar producto: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        try {
            Optional<Product> product = productService.read(id);
            if (product.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            productService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Error al eliminar producto: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
