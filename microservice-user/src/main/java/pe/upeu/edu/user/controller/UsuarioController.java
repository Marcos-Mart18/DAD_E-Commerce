package pe.upeu.edu.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.upeu.edu.user.entities.Usuario;
import pe.upeu.edu.user.request.RegisterRequest;
import pe.upeu.edu.user.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> usuarios = usuarioService.getAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Usuario> getById(@PathVariable("id") String keycloakId) {
        return usuarioService.getById(keycloakId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Usuario> create(@Validated @RequestBody Usuario usuario) {
        Usuario creado = usuarioService.create(usuario);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PutMapping("/perfil")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Usuario> updatePerfil(@AuthenticationPrincipal Jwt jwt,
                                                @RequestBody Usuario datosActualizados) {
        String keycloakId = jwt.getClaim("sub");

        return usuarioService.getById(keycloakId)
                .map(existente -> {
                    existente.setAvatar(datosActualizados.getAvatar());
                    existente.setPersona(datosActualizados.getPersona());
                    existente.setDirecciones(datosActualizados.getDirecciones());
                    existente.setTarjetas(datosActualizados.getTarjetas());
                    Usuario actualizado = usuarioService.update(existente);
                    return new ResponseEntity<>(actualizado, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/perfil")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Usuario> getMiPerfil(@AuthenticationPrincipal Jwt jwt) {
        String keycloakId = jwt.getClaim("sub");
        Usuario usuario = usuarioService.findByKeycloakId(keycloakId);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional<Usuario> usuario = usuarioService.getById(id);
        if (usuario.isPresent()) {
            usuarioService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        try {
            usuarioService.registrarUsuario(req);
            return ResponseEntity.ok("Usuario registrado con éxito");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado: " + e.getMessage()); // Error genérico
        }
    }


}
