package pe.upeu.edu.admin_panel.microservice_admin_panel.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.MovimientoDTO;

import java.util.List;

@FeignClient(name = "msvc-inventory", contextId = "movimientoClient", path = "/movimientos")
public interface MovimientoClient {

    @GetMapping
    List<MovimientoDTO> readAll();

    @GetMapping("/{id}")
    MovimientoDTO read(@PathVariable("id") Long id);

    @PostMapping
    MovimientoDTO create(@RequestBody MovimientoDTO movimientoDTO);

    @PutMapping("/{id}")
    MovimientoDTO update(@PathVariable("id") Long id, @RequestBody MovimientoDTO movimientoDTO);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id);
}
