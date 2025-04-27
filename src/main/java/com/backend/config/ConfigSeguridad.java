package com.backend.config;

import com.backend.service.JwtService;
import com.backend.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ConfigSeguridad {



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFiltroAutentificacion jwtAuthFilter) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers("/usuarios/**").hasRole("ADMIN")  // 🔒 Solo ADMIN puede gestionar usuarios
                        .requestMatchers("/telefonos/**").hasAnyRole("ADMIN", "USER") // 🔓 ADMIN y USER pueden acceder a teléfonos
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }




    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtFiltroAutentificacion jwtAuthenticationFilter(UsuarioService usuarioService, JwtService jwtService) {
        return new JwtFiltroAutentificacion(usuarioService, jwtService);
    }


}
