package pe.upeu.edu.admin_panel.microservice_admin_panel.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.CategoriaDTO;

import java.util.List;

@FeignClient(name = "msvc-catalog", contextId = "categoriaClient", path = "/categorias")
public interface CategoriaClient {

    @GetMapping
    List<CategoriaDTO> getAllCategories();

    @GetMapping("/{id}")
    CategoriaDTO getCategoryById(@PathVariable("id") Long id);

    @PostMapping
    CategoriaDTO createCategory(@RequestBody CategoriaDTO categoriaDTO);

    @PutMapping("/{id}")
    CategoriaDTO updateCategory(@PathVariable("id") Long id, @RequestBody CategoriaDTO categoriaDTO);

    @DeleteMapping("/{id}")
    void deleteCategory(@PathVariable("id") Long id);
}
