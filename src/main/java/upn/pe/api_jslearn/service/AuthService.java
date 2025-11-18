package upn.pe.api_jslearn.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import upn.pe.api_jslearn.model.Usuario;
import upn.pe.api_jslearn.repository.IUsuarioRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private final IUsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(IUsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // --- Registro ---
    public Usuario registrarUsuario(Usuario usuario) {

        // Normalizar correo
        String correo = usuario.getCorreo() != null
                ? usuario.getCorreo().trim().toLowerCase()
                : null;
        usuario.setCorreo(correo);

        // Verificar si existe
        Optional<Usuario> existente = usuarioRepository.findByCorreo(correo);
        if (existente.isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        // Rol y admin
        if (usuarioRepository.count() == 0) {
            usuario.setEsAdmin(true);
            usuario.setRol("ADMIN");
            usuario.setActivo(true); // primer admin se activa automáticamente
        } else {
            usuario.setEsAdmin(false);
            usuario.setRol("ESTUDIANTE");
            usuario.setActivo(false); // usuarios normales requieren confirmación
        }

        // Token de verificación
        usuario.setVerificationToken(UUID.randomUUID().toString());

        // Encriptar contraseña
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        return usuarioRepository.save(usuario);
    }

    // --- Confirmar cuenta ---
    public boolean confirmarCuenta(String token) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByVerificationToken(token);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setActivo(true);
            usuario.setVerificationToken(null);
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }

    // --- Login ---
    public Optional<Usuario> login(String correo, String password) {
        if (correo == null) return Optional.empty();

        String normalizado = correo.trim().toLowerCase();
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(normalizado);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (!usuario.isActivo()) return Optional.empty(); // usuario no activo
            if (passwordEncoder.matches(password, usuario.getPassword())) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }
}
