package upn.pe.api_jslearn.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtRequestFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        // 🔓 Rutas públicas sin token
        if (path.startsWith("/api/auth") ||
            path.startsWith("/api/cursos") || 
            path.startsWith("/api/usuarios") ||
            path.startsWith("/api/inscripciones") ||
            path.equals("/") ||
            path.startsWith("/css") ||
            path.startsWith("/js")) {

            filterChain.doFilter(request, response);
            return;
        }

        // 🔐 Leer encabezado Authorization
        String authHeader = request.getHeader("Authorization");

        // ❌ No hay token → Denegar acceso
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token requerido");
            return;
        }

        String token = authHeader.substring(7);

        // ❌ Token inválido
        if (!jwtUtil.isTokenValid(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token inválido o expirado");
            return;
        }

        // ✔ Extraer correo del token
        String correo = jwtUtil.extractCorreo(token);

        // ✔ Autenticar al usuario
        UsernamePasswordAuthenticationToken authentication =
        new UsernamePasswordAuthenticationToken(
            correo,
            null,
            List.of(new SimpleGrantedAuthority("ROLE_USER")) // rol mínimo
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }
}
