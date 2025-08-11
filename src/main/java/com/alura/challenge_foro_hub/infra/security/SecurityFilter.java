package com.alura.challenge_foro_hub.infra.security;

import com.alura.challenge_foro_hub.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;

    public SecurityFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // quita "Bearer "
            try {
                String correo = tokenService.getSubject(token);

                var usuario = usuarioRepository.findByCorreoElectronico(correo).orElse(null);

                if (usuario != null) {
                    var authorities = usuario.getPerfiles()
                            .stream()
                            .map(p -> new SimpleGrantedAuthority(p.getNombre())) // p.ej. "ROLE_USER"
                            .toList();

                    var authentication = new UsernamePasswordAuthenticationToken(usuario, null, authorities);
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    System.out.println("✅ Authentication seteada en SecurityContext");
                } else {
                }
            } catch (Exception e) {
                System.out.println("Error verificando token: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            }
        } else {
            System.out.println("Sin header Authorization o formato no Bearer. Continuando sin autenticar.");
        }

        filterChain.doFilter(request, response);
    }
}