package pe.upeu.edu.admin_panel.microservice_admin_panel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.upeu.edu.admin_panel.microservice_admin_panel.client.MovimientoClient;
import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.MovimientoDTO;
import pe.upeu.edu.admin_panel.microservice_admin_panel.service.MovimientoService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {
    private final MovimientoClient movimientoClient;

    @Override
    public MovimientoDTO create(MovimientoDTO movimiento) {
        return movimientoClient.create(movimiento);
    }

    @Override
    public MovimientoDTO update(MovimientoDTO movimiento) {
        return movimientoClient.update(movimiento.getId(), movimiento);
    }

    @Override
    public void delete(Long id) {
        movimientoClient.delete(id);
    }

    @Override
    public MovimientoDTO read(Long id) {
        return movimientoClient.read(id);
    }

    @Override
    public List<MovimientoDTO> readAll() {
        return movimientoClient.readAll();
    }
}
