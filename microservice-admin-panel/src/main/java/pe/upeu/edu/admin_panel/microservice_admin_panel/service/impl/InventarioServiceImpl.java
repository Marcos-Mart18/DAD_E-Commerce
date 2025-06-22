package pe.upeu.edu.admin_panel.microservice_admin_panel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.upeu.edu.admin_panel.microservice_admin_panel.client.InventarioClient;
import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.InventarioDTO;
import pe.upeu.edu.admin_panel.microservice_admin_panel.service.InventarioService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class InventarioServiceImpl implements InventarioService {
    public final InventarioClient inventarioClient;

    @Override
    public InventarioDTO create(InventarioDTO inventario) {
        return inventarioClient.create(inventario);
    }

    @Override
    public InventarioDTO update(InventarioDTO inventario) {
        return inventarioClient.update(inventario.getId(), inventario);
    }

    @Override
    public void delete(Long id) {
        inventarioClient.delete(id);
    }

    @Override
    public InventarioDTO read(Long id) {
        return inventarioClient.read(id);
    }

    @Override
    public List<InventarioDTO> readAll() {
        return inventarioClient.readAll();
    }
}
