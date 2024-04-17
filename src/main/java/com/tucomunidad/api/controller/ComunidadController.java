package com.tucomunidad.api.controller;

import com.tucomunidad.api.model.Comunidad;
import com.tucomunidad.api.service.ComunidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comunidades")
public class ComunidadController {

    @Autowired
    private ComunidadService comunidadService;

    @PostMapping
    public Comunidad createComunidad(@RequestBody Comunidad comunidad) {
        return comunidadService.save(comunidad);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comunidad> getComunidadById(@PathVariable Long id) {
        return comunidadService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
