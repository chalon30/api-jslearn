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

            // NO se genera token aquí; se envía correo de verificación
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of(
                            "message", "Usuario registrado. Revisa tu correo para activar tu cuenta.",
                            "correo", nuevoUsuario.getCorreo()
                    ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    // --- CONFIRMAR CUENTA ---
    @GetMapping("/confirmar")
    public ResponseEntity<?> confirmarCuenta(@RequestParam("token") String token) {
        boolean ok = authService.confirmarCuenta(token);

        if (ok) {
            return ResponseEntity.ok(Map.of(
                    "message", "Cuenta activada correctamente. Ya puedes iniciar sesión."
            ));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Token inválido o cuenta ya activada"));
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
                    .body(Map.of("error", "Credenciales inválidas o cuenta no activada"));
        }
    }
}
