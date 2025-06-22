package pe.upeu.edu.admin_panel.microservice_admin_panel.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.InventarioDTO;

import java.util.List;

@FeignClient(name = "msvc-inventory", contextId = "inventarioClient", path = "/inventarios")
public interface InventarioClient {

    @GetMapping
    List<InventarioDTO> readAll();

    @GetMapping("/{id}")
    InventarioDTO read(@PathVariable("id") Long id);

    @PostMapping
    InventarioDTO create(@RequestBody InventarioDTO inventarioDTO);

    @PutMapping("/{id}")
    InventarioDTO update(@PathVariable("id") Long id, @RequestBody InventarioDTO inventarioDTO);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id);
}
