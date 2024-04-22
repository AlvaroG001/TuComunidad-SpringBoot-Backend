package com.tucomunidad.api.controller;

import com.tucomunidad.api.model.Usuario;
import com.tucomunidad.api.service.UsuarioService;
import com.tucomunidad.api.service.ComunidadService;
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
    private ComunidadService comunidadService; // Ensure this service is autowired

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Usuario user) {
        logger.info("Attempting to create user with email: {}", user.getEmail());

        // Verificar si la comunidad existe
        if (!comunidadService.findById(user.getComunidad().getId()).isPresent()) {
            logger.error("Community ID {} not found", user.getComunidad().getId());
            return ResponseEntity.badRequest().body("Error: No existe una comunidad con el ID proporcionado.");
        }

        try {
            Usuario savedUser = usuarioService.save(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            logger.error("Error creating user: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
