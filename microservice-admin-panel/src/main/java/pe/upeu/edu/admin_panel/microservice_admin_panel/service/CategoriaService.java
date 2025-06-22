package pe.upeu.edu.admin_panel.microservice_admin_panel.service;

import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.CategoriaDTO;

import java.util.List;

public interface CategoriaService {
    CategoriaDTO createCategory(CategoriaDTO categoria);
    CategoriaDTO updateCategory(CategoriaDTO categoria);
    void deleteCategory(Long id);
    CategoriaDTO getCategoryById(Long id);
    List<CategoriaDTO> getAllCategories();
}
