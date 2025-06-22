package pe.upeu.edu.admin_panel.microservice_admin_panel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.InventarioDTO;
import pe.upeu.edu.admin_panel.microservice_admin_panel.service.InventarioService;

import java.util.List;

@RestController
@RequestMapping("/admin/inventarios")
@RequiredArgsConstructor
public class InventarioController {
    private final InventarioService inventoryService;

    @GetMapping
    public ResponseEntity<List<InventarioDTO>> readAll() {
        List<InventarioDTO> inventarios = inventoryService.readAll();
        if (inventarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(inventarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioDTO> read(@PathVariable Long id) {
        InventarioDTO inventario = inventoryService.read(id);
        if (inventario != null) {
            return new ResponseEntity<>(inventario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<InventarioDTO> create(@RequestBody InventarioDTO inventarioDTO) {
        InventarioDTO creado = inventoryService.create(inventarioDTO);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioDTO> update(@PathVariable Long id, @RequestBody InventarioDTO inventarioDTO) {
        inventarioDTO.setId(id); // asegurar consistencia del ID
        InventarioDTO actualizado = inventoryService.update(inventarioDTO);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        inventoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
