package pe.upeu.edu.inventory.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.edu.inventory.entities.Movimiento;
import pe.upeu.edu.inventory.service.MovimientoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public ResponseEntity<List<Movimiento>> readAll() {
        try {
            List<Movimiento> movimientos = movimientoService.readAll();
            if (movimientos.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movimientos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> read(@PathVariable("id") Long id) {
        try {
            Movimiento movimiento = movimientoService.read(id).orElse(null);
            if (movimiento != null) {
                return new ResponseEntity<>(movimiento, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Movimiento> create(@Valid @RequestBody Movimiento movimiento) {
        try {
            Movimiento nuevoMovimiento = movimientoService.create(movimiento);
            return new ResponseEntity<>(nuevoMovimiento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Movimiento movimiento) {
        Optional<Movimiento> movimientoData = movimientoService.read(id);
        if (movimientoData.isPresent()) {
            return new ResponseEntity<>(movimientoService.update(movimiento), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            Optional<Movimiento> movimiento = movimientoService.read(id);
            if (movimiento.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movimiento no encontrado con id: " + id);
            }
            movimientoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
