package pe.upeu.edu.catalog.microservice_catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.edu.catalog.microservice_catalog.entities.ProductDescription;
import pe.upeu.edu.catalog.microservice_catalog.service.ProductDescriptionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto-descripciones")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductDescriptionController {

    @Autowired
    private ProductDescriptionService productDescriptionService;

    @GetMapping
    public ResponseEntity<List<ProductDescription>> findAll() {
        try {
            List<ProductDescription> productos = productDescriptionService.readAll();
            if (productos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDescription> findById(@PathVariable("id") Long id) {
        try {
            Optional<ProductDescription> description = productDescriptionService.read(id);
            if (!description.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(description.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<ProductDescription> create(@RequestBody ProductDescription productDescription) {
        try {
            ProductDescription description = productDescriptionService.create(productDescription);
            return new ResponseEntity<>(description, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDescription> update(@PathVariable("id") Long id, @RequestBody ProductDescription productDescription) {
        try {
            Optional<ProductDescription> existingDescription = productDescriptionService.read(id);
            if (!existingDescription.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            productDescription.setId(id);
            ProductDescription updated = productDescriptionService.update(productDescription);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            Optional<ProductDescription> optional = productDescriptionService.read(id);
            if (!optional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            productDescriptionService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
