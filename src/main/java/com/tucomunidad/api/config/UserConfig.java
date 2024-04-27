package com.tucomunidad.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tucomunidad.api.model.Usuario;
import com.tucomunidad.api.repository.UsuarioRepository;

@Configuration
public class UserConfig {
  @Autowired
  private UsuarioRepository usuarioRepository; // Repositorio de usuarios

  @Autowired
  private PasswordEncoder passwordEncoder; // Inyección del bean definido en SecurityBeansConfig

  @Bean
  public UserDetailsService userDetailsService() {
    return username -> {
      Usuario usuario = usuarioRepository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

      return User.withUsername(usuario.getEmail())
        .password(passwordEncoder.encode(usuario.getPassword())) // Usa BCrypt para cifrar contraseñas
        .roles("USER") // Asigna roles, se puede ajustar según tu necesidad
        .build();
    };
  }
}
