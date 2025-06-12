package pe.edu.upeu.dad_project.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.dad_project.domain.Method;
import pe.edu.upeu.dad_project.repository.MethodRepository;
import pe.edu.upeu.dad_project.services.MethodService;

import java.util.List;
import java.util.Optional;

@Service
public class MethodServiceImpl implements MethodService {
    @Autowired
    private MethodRepository methodRepository;

    @Override
    public Method create(Method method) {
        return methodRepository.save(method);
    }

    @Override
    public Method update(Method method) {
        return methodRepository.save(method);
    }
    @Override
    public void delete(Long id) {
        methodRepository.deleteById(id);
    }

    @Override
    public Optional<Method> getById(Long id) {
        return methodRepository.findById(id);
    }

    @Override
    public List<Method> getAll() {
        return methodRepository.findAll();
    }
    }
