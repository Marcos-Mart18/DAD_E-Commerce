package pe.upeu.edu.inventory.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.edu.inventory.entities.Inventario;
import pe.upeu.edu.inventory.service.InventarioService;

import java.util.List;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<Inventario>> readAll(){
        try {
            List<Inventario> inventarios = inventarioService.readAll();
            if (inventarios.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(inventarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> read(@PathVariable("id") Long id){
        try {
            Inventario inventario = inventarioService.read(id).get();
            return new ResponseEntity<>(inventario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Inventario inventario){
        try {
            if (inventario.getIdProducto() == null) {
                return ResponseEntity.badRequest().body("El idProducto es obligatorio");
            }
            var producto = inventarioService.obtenerProductoPorId(inventario.getIdProducto());
            if (producto == null) {
                return ResponseEntity.badRequest().body("Producto no existe con id: " + inventario.getIdProducto());
            }
            Inventario creado = inventarioService.create(inventario);
            return new ResponseEntity<>(creado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Inventario inventario){
        if (inventario.getIdProducto() == null) {
            return ResponseEntity.badRequest().body("El idProducto es obligatorio");
        }
        var producto = inventarioService.obtenerProductoPorId(inventario.getIdProducto());
        if (producto == null) {
            return ResponseEntity.badRequest().body("Producto no existe con id: " + inventario.getIdProducto());
        }
        if (inventarioService.read(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        inventario.setId(id);
        Inventario actualizado = inventarioService.update(inventario);
        return ResponseEntity.ok(actualizado);
    }
}
