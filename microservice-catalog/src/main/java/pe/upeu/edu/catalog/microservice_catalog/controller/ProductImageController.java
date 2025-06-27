package pe.upeu.edu.catalog.microservice_catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.upeu.edu.catalog.microservice_catalog.entities.ProductImage;
import pe.upeu.edu.catalog.microservice_catalog.service.FirebaseStorageService;
import pe.upeu.edu.catalog.microservice_catalog.service.ProductImageService;
import pe.upeu.edu.catalog.microservice_catalog.service.ProductService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/producto-imagenes")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductImage>> findAll() {
        try {
            List<ProductImage> imagenes = productImageService.readAll();
            if (imagenes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(imagenes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{productId}/upload")
    public ResponseEntity<ProductImage> uploadImage(
            @PathVariable("productId") Long productId,
            @RequestParam("file") MultipartFile file,
            @RequestParam("main") boolean main) {
        try {
            var product = productService.read(productId).orElse(null);
            if (product == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            // Subir la imagen a Firebase y obtener la URL pública
            String fileName = firebaseStorageService.uploadImageToFirebase(file, productId.toString());

            // Crear el objeto ProductImage y asociarlo al producto
            ProductImage productImage = new ProductImage();
            productImage.setImageUrl(fileName);
            productImage.setProduct(product);
            productImage.setMain(main);

            // Guardar la imagen en la base de datos
            ProductImage savedImage = productImageService.create(productImage);

            return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductImage> updateProductImage(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) {
        try {
            ProductImage existingImage = productImageService.read(id).orElse(null);
            if (existingImage == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // Eliminar la imagen anterior de Firebase
            firebaseStorageService.deleteImageFromFirebase(existingImage.getImageUrl());

            // Subir la nueva imagen a Firebase y obtener la URL pública
            String newFileName = firebaseStorageService.uploadImageToFirebase(file, existingImage.getProduct().getId().toString());

            // Actualizar la imagen
            existingImage.setImageUrl(newFileName);
            ProductImage updatedImage = productImageService.update(existingImage);

            return new ResponseEntity<>(updatedImage, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductImage(@PathVariable Long id) {
        try {
            ProductImage existingImage = productImageService.read(id).orElse(null);
            if (existingImage == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // Eliminar la imagen físicamente de Firebase
            firebaseStorageService.deleteImageFromFirebase(existingImage.getImageUrl());

            // Eliminar la imagen de la base de datos
            productImageService.delete(id);

            return ResponseEntity.noContent().build(); // Respuesta exitosa sin contenido
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error en la eliminación
        }
    }
}
