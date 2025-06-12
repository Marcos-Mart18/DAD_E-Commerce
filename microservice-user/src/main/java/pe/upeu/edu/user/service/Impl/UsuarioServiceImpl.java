package pe.upeu.edu.user.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.edu.user.client.KeycloakAdminClientService;
import pe.upeu.edu.user.entities.Persona;
import pe.upeu.edu.user.entities.Usuario;
import pe.upeu.edu.user.repository.UsuarioRepository;
import pe.upeu.edu.user.request.RegisterRequest;
import pe.upeu.edu.user.service.UsuarioService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private KeycloakAdminClientService keycloakAdmin;

    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(String keycloakId) {
        usuarioRepository.deleteById(keycloakId);
    }

    @Override
    public Optional<Usuario> getById(String keycloakId) {
        return usuarioRepository.findById(keycloakId);
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findByKeycloakId(String keycloakId) {
        return usuarioRepository.findByKeycloakId(keycloakId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con keycloakId: " + keycloakId));
    }

    @Override
    public void registrarUsuario(RegisterRequest req) {
        // Verificar si el usuario ya existe
        if (keycloakAdmin.isUsernameTaken(req.getUsername())) {
            throw new IllegalArgumentException("El nombre de usuario ya está registrado en Keycloak");
        }

        // Registro en Keycloak
        String keycloakId = keycloakAdmin.createUser(
                req.getUsername(),
                req.getPassword(),
                req.getEmail(),
                req.getPersona().getNombres(),
                req.getPersona().getApellidos()
        );

        // Crear la entidad Usuario
        Usuario usuario = new Usuario();
        usuario.setKeycloakId(keycloakId);
        usuario.setFechaRegistro(LocalDateTime.now());
        usuario.setAvatar("https://default-avatar.png");
        usuario.setPersona(req.getPersona());

        // Guardar el usuario en la base de datos
        usuarioRepository.save(usuario);
    }

}
