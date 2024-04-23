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

    @PostMapping("/{votacionId}/vote")
    public ResponseEntity<Votacion> updateVotacion(@PathVariable Long votacionId, @RequestBody Votacion votacion) {
        Votacion updatedVotacion = votacionService.updateVotacion(votacionId, votacion);
        if (updatedVotacion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedVotacion);
    }

    @GetMapping
    public ResponseEntity<?> getVotaciones(@RequestParam(required = false) String communityId) {
        try {
            if (communityId != null && !communityId.isEmpty()) {
                Long id = Long.parseLong(communityId);
                List<Votacion> votaciones = votacionService.findByCommunityId(id);
                return ResponseEntity.ok(votaciones);
            }
            return ResponseEntity.ok(votacionService.findAll());
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid community ID: " + communityId);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVotacion(@PathVariable Long id) {
        votacionService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
