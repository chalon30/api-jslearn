package upn.pe.api_jslearn.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class StartupConfig {

    @Value("${server.port}")
    private String port;

    @EventListener(ApplicationReadyEvent.class)
    public void mostrarRuta() {
        System.out.println("---------------------------------------------------");
        System.out.println("API iniciada correctamente");
        System.out.println("Accede desde: http://localhost:" + port + "/");
        System.out.println("---------------------------------------------------");
    }
}