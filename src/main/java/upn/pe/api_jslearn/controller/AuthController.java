package upn.pe.api_jslearn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import upn.pe.api_jslearn.model.Usuario;
import upn.pe.api_jslearn.security.JwtUtil;
import upn.pe.api_jslearn.service.AuthService;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    // --- REGISTRO ---
    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = authService.registrarUsuario(usuario);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of(
                            "message", "Usuario registrado correctamente.",
                            "correo", nuevoUsuario.getCorreo()
                    ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    // --- LOGIN ---
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario credenciales) {
        Optional<Usuario> usuarioOpt = authService.login(
                credenciales.getCorreo(),
                credenciales.getPassword()
        );

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            String token = jwtUtil.generateToken(usuario.getCorreo());

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "correo", usuario.getCorreo(),
                    "rol", usuario.getRol(),
                    "esAdmin", usuario.isEsAdmin()
            ));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Credenciales inválidas"));
        }
    }
}
