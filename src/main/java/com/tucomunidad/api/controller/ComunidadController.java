package com.tucomunidad.api.controller;

import com.tucomunidad.api.model.Comunidad;
import com.tucomunidad.api.service.ComunidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comunidades")
public class ComunidadController {

    @Autowired
    private ComunidadService comunidadService;

    @GetMapping
    public List<Comunidad> getAllComunidades() {
        return comunidadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comunidad> getComunidadById(@PathVariable Long id) {
        return comunidadService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> checkCommunityExists(@PathVariable Long id) {
        boolean exists = comunidadService.findById(id).isPresent();
        return ResponseEntity.ok(exists);
    }

    @PostMapping
    public ResponseEntity<Comunidad> createComunidad(@RequestBody Comunidad comunidad) {
        Comunidad savedComunidad = comunidadService.save(comunidad);
        return ResponseEntity.ok(savedComunidad);
    }
}