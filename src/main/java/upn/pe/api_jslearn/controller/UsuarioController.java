package upn.pe.api_jslearn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import upn.pe.api_jslearn.model.Usuario;
import upn.pe.api_jslearn.service.UsuarioService;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final BCryptPasswordEncoder passwordEncoder;

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obtener(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        boolean eliminado = usuarioService.eliminarUsuario(id);

        if (eliminado) {
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
    }

    @PutMapping("/activar/{id}")
    public ResponseEntity<String> activarUsuario(@PathVariable Long id) {
        Optional<Usuario> usuarioOpt = usuarioService.buscarPorId(id);

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }

        Usuario usuario = usuarioOpt.get();
        usuario.setActivo(true);
        usuarioService.guardarUsuario(usuario); // ✅ guardar cambios
        return ResponseEntity.ok("Usuario activado correctamente");
    }

    @PutMapping("/cambiar-contrasena/{id}")
    public ResponseEntity<String> cambiarContrasena(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {

        String nueva = body.get("nueva");
        String confirmar = body.get("confirmar");

        if (nueva == null || confirmar == null || !nueva.equals(confirmar)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Las contraseñas no coinciden");
        }

        Optional<Usuario> usuarioOpt = usuarioService.buscarPorId(id);
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

        Usuario usuario = usuarioOpt.get();
        usuario.setPassword(passwordEncoder.encode(nueva));
        usuarioService.guardarUsuario(usuario);

        return ResponseEntity.ok("Contraseña actualizada correctamente");
    }

    @PutMapping("/{id}/rol")
    public ResponseEntity<?> actualizarRol(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {
        String nuevoRol = body.get("rol");

        if (nuevoRol == null || nuevoRol.isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El rol es obligatorio");
        }

        // Normaliza mayúsculas
        nuevoRol = nuevoRol.toUpperCase();

        // Solo se permiten ALUMNO y PROFESOR desde este endpoint
        if (!nuevoRol.equals("ALUMNO") && !nuevoRol.equals("PROFESOR")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Solo se permite cambiar entre roles ALUMNO y PROFESOR");
        }

        Optional<Usuario> usuarioOpt = usuarioService.buscarPorId(id);
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }

        Usuario usuario = usuarioOpt.get();

        // No se puede tocar un ADMIN
        if ("ADMIN".equalsIgnoreCase(usuario.getRol())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("No se puede modificar el rol de un usuario ADMIN");
        }

        // Tampoco permitir convertir a ADMIN desde aquí (por si acaso)
        if ("ADMIN".equalsIgnoreCase(nuevoRol)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("No se puede asignar el rol ADMIN desde este endpoint");
        }

        // Hasta aquí ya sabemos que es ALUMNO o PROFESOR y el usuario no es ADMIN
        usuario.setRol(nuevoRol);
        usuarioService.guardarUsuario(usuario);

        return ResponseEntity.ok(Map.of(
                "mensaje", "Rol actualizado correctamente",
                "rol", usuario.getRol()));
    }

}
