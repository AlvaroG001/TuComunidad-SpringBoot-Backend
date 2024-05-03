package com.tucomunidad.api.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.http.HttpMethod; 
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {   

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
        .csrf(csrf -> {csrf.disable();})
        .authorizeHttpRequests(auth -> { 
            auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll(); // Permitir todas las solicitudes OPTIONS
            auth.requestMatchers("/api/usuarios").permitAll();
            auth.requestMatchers("/login", "/register").permitAll();  // Asegura acceso sin autenticación
            auth.requestMatchers("/h2-console/**").permitAll();       // Si usas la consola H2 en desarrollo
            auth.anyRequest().authenticated();                                    // Todos los demás requieren autenticación
        })                  
        .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/home", true).permitAll())
        .logout(logout -> logout.logoutUrl("/logout").permitAll());
        
    http.headers(headers -> headers.frameOptions(FrameOptionsConfig::disable));  // Permitir la visualización dentro de un marco

    return http.build();
}

@Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Asegúrate de que el origen es correcto
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-Auth-Token"));
    configuration.setAllowCredentials(true);
    configuration.setExposedHeaders(Arrays.asList("X-Auth-Token", "Authorization", "Content-Type"));

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
}



    @Bean
    public UserDetailsService jdbcUserDetailsService(DataSource dataSource) {
        String usersByUsernameQuery = "select usuario, clave, true from users where usuario = ?";
        String authsByUserQuery = "select usuario, permiso from users where usuario = ?";
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery(usersByUsernameQuery);
        users.setAuthoritiesByUsernameQuery(authsByUserQuery);
        return users;
    }
}
