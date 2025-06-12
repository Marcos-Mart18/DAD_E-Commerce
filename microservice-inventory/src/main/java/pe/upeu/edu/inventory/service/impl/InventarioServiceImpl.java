package pe.upeu.edu.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.edu.inventory.client.ProductClient;
import pe.upeu.edu.inventory.dto.ProductDTO;
import pe.upeu.edu.inventory.entities.Inventario;
import pe.upeu.edu.inventory.repository.InventarioRepository;
import pe.upeu.edu.inventory.service.InventarioService;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class InventarioServiceImpl implements InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    private final ProductClient productClient;

    @Override
    public ProductDTO obtenerProductoPorId(Long idProducto) {
        return productClient.getProductById(idProducto);
    }

    @Override
    public Inventario create(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public Inventario update(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public void delete(Long Id) {
        inventarioRepository.deleteById(Id);
    }

    @Override
    public Optional<Inventario> read(Long Id) {
        return inventarioRepository.findById(Id);
    }

    @Override
    public List<Inventario> readAll() {
        return inventarioRepository.findAll();
    }
}
