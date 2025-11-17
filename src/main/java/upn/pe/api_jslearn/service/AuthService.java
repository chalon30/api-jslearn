package upn.pe.api_jslearn.service;

import org.springframework.stereotype.Service;
import upn.pe.api_jslearn.model.Usuario;
import upn.pe.api_jslearn.repository.IUsuarioRepository;

import java.util.Optional;

@Service
public class AuthService {

    private final IUsuarioRepository usuarioRepository;

    public AuthService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // --- Registro ---
    public Usuario registrarUsuario(Usuario usuario) {

        // Normalizar correo (trim + minúsculas)
        String correo = usuario.getCorreo() != null
                ? usuario.getCorreo().trim().toLowerCase()
                : null;
        usuario.setCorreo(correo);

        // Si el correo existe => error
        Optional<Usuario> existente = usuarioRepository.findByCorreo(correo);

        if (existente.isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        // Nuevo usuario
        if (usuarioRepository.count() == 0) {
            usuario.setEsAdmin(true);
            usuario.setRol("ADMIN");
        } else {
            usuario.setEsAdmin(false);
            if (usuario.getRol() == null || usuario.getRol().isBlank()) {
                usuario.setRol("ESTUDIANTE"); // rol por defecto
            }
        }

        // Usuario activo directo
        usuario.setActivo(true);
        usuario.setVerificationToken(null); // ya no hay token

        return usuarioRepository.save(usuario);
    }

    // --- Confirmar cuenta ---
    public boolean confirmarCuenta(String token) {
        // Ya no hay token, simplemente devolver true
        return true;
    }

    // --- Login ---
    public Optional<Usuario> login(String correo, String password) {
        if (correo == null) {
            return Optional.empty();
        }

        String normalizado = correo.trim().toLowerCase();
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(normalizado);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            // Comparación simple (luego se puede cambiar a BCrypt)
            if (usuario.getPassword().equals(password)) {
                return Optional.of(usuario);
            }
        }

        return Optional.empty();
    }
}
