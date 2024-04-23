package com.tucomunidad.api.controller;

import com.tucomunidad.api.model.Votacion;
import com.tucomunidad.api.service.VotacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votaciones")
public class VotacionController {

    @Autowired
    private VotacionService votacionService;

    @PostMapping
    public ResponseEntity<Votacion> createVotacion(@RequestBody Votacion votacion) {
        Votacion savedVotacion = votacionService.save(votacion);
        return ResponseEntity.ok(savedVotacion);
    }

    @GetMapping
    public ResponseEntity<List<Votacion>> getAllVotaciones() {
        return ResponseEntity.ok(votacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Votacion> getVotacionById(@PathVariable Long id) {
        return votacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVotacion(@PathVariable Long id) {
        votacionService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
