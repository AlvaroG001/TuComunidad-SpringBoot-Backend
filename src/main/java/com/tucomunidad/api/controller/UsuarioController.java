package com.tucomunidad.api.controller;

import com.tucomunidad.api.model.Usuario;
import com.tucomunidad.api.service.ComunidadService;
import com.tucomunidad.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ComunidadService comunidadService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @PostMapping("/check-email")
    public ResponseEntity<Boolean> checkEmailExistence(@RequestBody Usuario user) {
        boolean exists = usuarioService.findByEmail(user.getEmail()).isPresent();
        return ResponseEntity.ok(exists);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Usuario user) {
        logger.info("Attempting to create user with email: {}", user.getEmail());

        return comunidadService.findById(user.getComunidad().getId())
            .map(comunidad -> {
                user.setComunidad(comunidad); // Asegura que la comunidad está correctamente asociada
                try {
                    Usuario savedUser = usuarioService.save(user);
                    return ResponseEntity.ok(savedUser);
                } catch (Exception e) {
                    logger.error("Error saving user: ", e);
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el usuario");
                }
            })
            .orElseGet(() -> {
                logger.error("Community ID {} not found", user.getComunidad().getId());
                return ResponseEntity.badRequest().body("Error: No existe una comunidad con el ID proporcionado.");
            });
    }


}
