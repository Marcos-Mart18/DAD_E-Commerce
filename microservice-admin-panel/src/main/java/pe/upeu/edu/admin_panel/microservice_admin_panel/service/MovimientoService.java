package pe.upeu.edu.admin_panel.microservice_admin_panel.service;

import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.MovimientoDTO;

import java.util.List;

public interface MovimientoService {
    MovimientoDTO create(MovimientoDTO movimiento);
    MovimientoDTO update(MovimientoDTO movimiento);
    void delete(Long id);
    MovimientoDTO read(Long id);
    List<MovimientoDTO> readAll();
}
