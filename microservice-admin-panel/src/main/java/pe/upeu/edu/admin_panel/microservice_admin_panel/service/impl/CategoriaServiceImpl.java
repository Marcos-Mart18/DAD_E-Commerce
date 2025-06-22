package pe.upeu.edu.admin_panel.microservice_admin_panel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.upeu.edu.admin_panel.microservice_admin_panel.client.CategoriaClient;
import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.CategoriaDTO;
import pe.upeu.edu.admin_panel.microservice_admin_panel.service.CategoriaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaClient categoriaClient;

    @Override
    public List<CategoriaDTO> getAllCategories() {
        return categoriaClient.getAllCategories();
    }

    @Override
    public CategoriaDTO createCategory(CategoriaDTO categoria) {
        return categoriaClient.createCategory(categoria);
    }

    @Override
    public CategoriaDTO updateCategory(CategoriaDTO categoria) {
        return categoriaClient.updateCategory(categoria.getId(), categoria);
    }

    @Override
    public void deleteCategory(Long id) {
        categoriaClient.deleteCategory(id);
    }

    @Override
    public CategoriaDTO getCategoryById(Long id) {
        return categoriaClient.getCategoryById(id);
    }
}
