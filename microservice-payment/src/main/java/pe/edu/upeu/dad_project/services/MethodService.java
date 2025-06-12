package pe.edu.upeu.dad_project.services;

import pe.edu.upeu.dad_project.domain.Method;

import java.util.List;
import java.util.Optional;

public interface MethodService {
    Method create(Method method);
    Method update(Method method);
    void delete(Long id);
    Optional<Method> getById(Long id);
    List<Method> getAll();
}
