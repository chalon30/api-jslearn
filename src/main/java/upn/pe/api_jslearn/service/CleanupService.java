package upn.pe.api_jslearn.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import upn.pe.api_jslearn.model.Usuario;
import upn.pe.api_jslearn.repository.IUsuarioRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CleanupService {

    private final IUsuarioRepository usuarioRepository;

    public CleanupService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Ejecuta la limpieza cada hora
    @Scheduled(cron = "0 0 * * * *") // cada hora en punto
    public void eliminarUsuariosPendientes() {
        LocalDateTime limite = LocalDateTime.now().minusHours(24);

        List<Usuario> pendientes = usuarioRepository.findAll().stream()
                .filter(u -> !u.isActivo() && u.getCreatedAt().isBefore(limite))
                .toList();

        usuarioRepository.deleteAll(pendientes);

        System.out.println("Usuarios pendientes eliminados: " + pendientes.size());
    }
}
