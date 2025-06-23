package pe.upeu.edu.catalog.microservice_catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upeu.edu.catalog.microservice_catalog.entities.ProductImage;
import pe.upeu.edu.catalog.microservice_catalog.service.ProductImageService;

import java.util.List;

@RestController
@RequestMapping("/producto-imagenes")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductImageController {
    @Autowired
    private ProductImageService productImageService;

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
}
