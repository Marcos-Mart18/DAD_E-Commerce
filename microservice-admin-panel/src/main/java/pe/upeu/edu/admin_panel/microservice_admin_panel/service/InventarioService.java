package pe.upeu.edu.admin_panel.microservice_admin_panel.service;

import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.InventarioDTO;

import java.util.List;

public interface InventarioService {
    InventarioDTO create(InventarioDTO inventario);
    InventarioDTO update(InventarioDTO inventario);
    void delete(Long id);
    InventarioDTO read(Long id);
    List<InventarioDTO> readAll();
}
