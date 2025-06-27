package pe.upeu.edu.catalog.microservice_catalog.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.upeu.edu.catalog.microservice_catalog.entities.Category;
import pe.upeu.edu.catalog.microservice_catalog.service.CategoryService;
import pe.upeu.edu.catalog.microservice_catalog.service.FirebaseStorageService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        try {
            List<Category> categories = categoryService.readAll();
            if (categories.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
        try {
            Category category = categoryService.read(id).orElse(null);
            if (category == null) {
                return ResponseEntity.notFound().build();
            }
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> createCategory(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile image) {
        try {
            Category category = new Category();
            category.setName(name);
            category.setDescription(description);

            // Guardar la imagen en Firebase y obtener la URL pública
            String imageUrl = firebaseStorageService.uploadImageToFirebase(image, name);

            category.setImage(imageUrl); // Establecer la URL de la imagen

            // Crear la categoría
            Category createdCategory = categoryService.create(category);

            return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al crear la categoría: {}", e.getMessage(), e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(
            @PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam(value = "image", required = false) MultipartFile image) {

        return categoryService.read(id).map(category -> {
            try {
                // Si hay nueva imagen, elimina la antigua y sube la nueva
                if (image != null && !image.isEmpty()) {
                    firebaseStorageService.deleteImageFromFirebase(category.getImage());
                    String imageUrl = firebaseStorageService.uploadImageToFirebase(image, name);
                    category.setImage(imageUrl);
                }

                category.setName(name);
                category.setDescription(description);
                categoryService.update(category);

                return ResponseEntity.ok(category);

            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error al actualizar categoría: " + e.getMessage());
            }
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Categoría no encontrada con ID: " + id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        return categoryService.read(id).map(category -> {
            try {
                firebaseStorageService.deleteImageFromFirebase(category.getImage());
                categoryService.delete(id);
                return ResponseEntity.ok("Categoría eliminada correctamente.");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error al eliminar la categoría: " + e.getMessage());
            }
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Categoría no encontrada con ID: " + id));
    }

}
