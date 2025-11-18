package upn.pe.api_jslearn.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import upn.pe.api_jslearn.model.Usuario;
import upn.pe.api_jslearn.repository.IUsuarioRepository;

@Component
public class UserSeeder implements CommandLineRunner {

    private final IUsuarioRepository usuarioRepository;

    public UserSeeder(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) {

        // Crear usuario ADMIN solo si no existe
        if (usuarioRepository.existsByCorreo("admin@devschool.com")) {
            System.out.println("Usuario ADMIN ya existe, seed omitido.");
            return;
        }

        System.out.println("No existen usuarios ADMIN, creando uno por defecto...");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Usuario admin = new Usuario();
        admin.setNombre("Admin");
        admin.setApellidos("Principal");
        admin.setCorreo("admin@devschool.com");
        admin.setPassword(passwordEncoder.encode("admin123")); // Contraseña encriptada
        admin.setRol("ADMIN");
        admin.setEsAdmin(true);
        admin.setActivo(true);
        admin.setVerificationToken(null);

        usuarioRepository.save(admin);

        System.out.println("Usuario ADMIN creado correctamente.");
    }
}
