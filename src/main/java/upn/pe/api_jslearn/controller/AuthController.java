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

    // Registro
    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = authService.registrarUsuario(usuario);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of(
                            "message", "Usuario registrado correctamente. Confirma tu cuenta con el token.",
                            "correo", nuevoUsuario.getCorreo(),
                            "token", nuevoUsuario.getVerificationToken() // devolver token para pruebas
                    ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario credenciales) {

        Optional<Usuario> usuarioOpt = authService.login(
                credenciales.getCorreo(),
                credenciales.getPassword()
        );

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Credenciales inválidas o cuenta no confirmada"));
        }

        Usuario usuario = usuarioOpt.get();
        String token = jwtUtil.generateToken(usuario.getCorreo());

        return ResponseEntity.ok(Map.of(
                "token", token,
                "id", usuario.getId(),
                "nombre", usuario.getNombre(),
                "apellidos", usuario.getApellidos(),
                "correo", usuario.getCorreo(),
                "rol", usuario.getRol(),
                "esAdmin", usuario.isEsAdmin()
        ));
    }

    // Confirmar cuenta
    @PostMapping("/confirm")
    public ResponseEntity<?> confirmarCuenta(@RequestParam String token) {
        boolean confirmado = authService.confirmarCuenta(token);
        if (confirmado) {
            return ResponseEntity.ok(Map.of("message", "Cuenta confirmada correctamente."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Token inválido."));
        }
    }


    @PostMapping("/admin-login")
public ResponseEntity<?> adminLogin(@RequestBody Usuario credenciales) {

    Optional<Usuario> usuarioOpt = authService.login(
            credenciales.getCorreo(),
            credenciales.getPassword()
    );

    if (usuarioOpt.isEmpty()) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "Credenciales inválidas o cuenta no confirmada"));
    }

    Usuario usuario = usuarioOpt.get();

    String rol = usuario.getRol() != null ? usuario.getRol().toUpperCase() : "";

    // 🔒 Solo ADMIN o PROFESOR pueden entrar aquí
    if (!"ADMIN".equals(rol) && !"PROFESOR".equals(rol)) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Map.of(
                        "error", "Solo usuarios con rol ADMIN o PROFESOR pueden acceder a este panel"
                ));
    }

    String token = jwtUtil.generateToken(usuario.getCorreo());

    return ResponseEntity.ok(Map.of(
            "token", token,
            "id", usuario.getId(),
            "nombre", usuario.getNombre(),
            "apellidos", usuario.getApellidos(),
            "correo", usuario.getCorreo(),
            "rol", usuario.getRol(),
            "esAdmin", usuario.isEsAdmin()
    ));
}
}
