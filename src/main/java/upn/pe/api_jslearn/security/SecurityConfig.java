package upn.pe.api_jslearn.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // ❌ Desactiva CSRF (solo para APIs REST)
            .csrf(csrf -> csrf.disable())

            // ✅ Definir rutas públicas y protegidas con la nueva API
            .authorizeHttpRequests(auth -> auth
                // Rutas públicas (sin autenticación)
                .requestMatchers(
                    "/api/auth/**",
                    "/api/cursos/**",
                    "/",
                    "/index.html",
                    "/css/**",
                    "/js/**",
                    "/api/**"
                ).permitAll()

                // Todas las demás requieren autenticación
                .anyRequest().authenticated()
            )

            // Agrega el filtro JWT antes del filtro de autenticación por defecto
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

