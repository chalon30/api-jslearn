package upn.pe.api_jslearn.service;

import org.springframework.stereotype.Service;
import upn.pe.api_jslearn.model.Usuario;
import upn.pe.api_jslearn.repository.IUsuarioRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private final IUsuarioRepository usuarioRepository;
    private final EmailService emailService;

    public AuthService(IUsuarioRepository usuarioRepository, EmailService emailService) {
        this.usuarioRepository = usuarioRepository;
        this.emailService = emailService;
    }

    // --- Registro ---
    public Usuario registrarUsuario(Usuario usuario) {

        // Normalizar correo (trim + minúsculas)
        String correo = usuario.getCorreo() != null
                ? usuario.getCorreo().trim().toLowerCase()
                : null;
        usuario.setCorreo(correo);

        // Validar formato de correo
        if (!esCorreoValido(correo)) {
            throw new RuntimeException("El correo no es válido. Ingresa un correo real.");
        }

        // Bloquear correos temporales (Mailinator, Yopmail, etc.)
        if (esCorreoTemporal(correo)) {
            throw new RuntimeException("No se aceptan correos temporales.");
        }

        // Si el correo existe y está ACTIVO => error
        Optional<Usuario> existente = usuarioRepository.findByCorreo(correo);

        if (existente.isPresent() && existente.get().isActivo()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        // Si el correo existe pero está INACTIVO → reenviar correo + no crear otro usuario
        if (existente.isPresent() && !existente.get().isActivo()) {

            Usuario pendiente = existente.get();

            // generar nuevo token
            String nuevoToken = UUID.randomUUID().toString();
            pendiente.setVerificationToken(nuevoToken);

            usuarioRepository.save(pendiente);

            // reenviar correo
            emailService.sendVerificationEmail(
                    pendiente.getCorreo(),
                    pendiente.getNombre(),
                    nuevoToken
            );

            return pendiente;
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

        // cuenta inactiva hasta confirmar
        usuario.setActivo(false);
        usuario.setVerificationToken(UUID.randomUUID().toString());

        Usuario guardado = usuarioRepository.save(usuario);

        // enviar correo de verificación
        emailService.sendVerificationEmail(
                guardado.getCorreo(),
                guardado.getNombre(),
                guardado.getVerificationToken()
        );

        return guardado;
    }

    // --- Confirmar cuenta ---
    public boolean confirmarCuenta(String token) {
        Optional<Usuario> opt = usuarioRepository.findByVerificationToken(token);

        if (opt.isEmpty()) {
            return false; // token inválido
        }

        Usuario usuario = opt.get();
        usuario.setActivo(true);
        usuario.setVerificationToken(null); // limpia el token

        usuarioRepository.save(usuario);
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

            // debe estar activo
            if (!usuario.isActivo()) {
                return Optional.empty();
            }

            // Comparación simple (luego lo cambiamos a BCrypt)
            if (usuario.getPassword().equals(password)) {
                return Optional.of(usuario);
            }
        }

        return Optional.empty();
    }

    // --- Helpers de validación de correo ---

    private boolean esCorreoValido(String correo) {
        if (correo == null) return false;
        // Formato estándar: usuario@dominio.tld
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return correo.matches(regex);
    }

    private static final String[] CORREOS_TEMPORALES = {
            "mailinator.com",
            "yopmail.com",
            "tempmail.com",
            "10minutemail.com",
            "guerrillamail.com"
    };

    private boolean esCorreoTemporal(String correo) {
        String dominio = correo.substring(correo.indexOf("@") + 1).toLowerCase();
        for (String temp : CORREOS_TEMPORALES) {
            if (dominio.contains(temp)) {
                return true;
            }
        }
        return false;
    }
}
