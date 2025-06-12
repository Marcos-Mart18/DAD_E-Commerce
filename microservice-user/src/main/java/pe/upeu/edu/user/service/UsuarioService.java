package pe.upeu.edu.user.service;

import pe.upeu.edu.user.entities.Usuario;
import pe.upeu.edu.user.request.RegisterRequest;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario create(Usuario usuario);
    Usuario update(Usuario usuario);
    void delete(String keycloakId);
    Optional<Usuario> getById(String keycloakId);
    List<Usuario> getAll();
    Usuario findByKeycloakId(String keycloakId);
    void registrarUsuario(RegisterRequest req);
}

