package com.tucomunidad.api.controller;

import com.tucomunidad.api.model.Reunion;
import com.tucomunidad.api.service.ReunionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reuniones")
public class ReunionController {

    @Autowired
    private ReunionService reunionService;

    @GetMapping
    public ResponseEntity<?> getReuniones(@RequestParam(required = false) String communityId) {
        try {
            if (communityId != null && !communityId.isEmpty()) {
                Long id = Long.parseLong(communityId);
                List<Reunion> reuniones = reunionService.findByCommunityId(id);
                return ResponseEntity.ok(reuniones);
            }
            return ResponseEntity.ok(reunionService.findAll());
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid community ID: " + communityId);
        }
    }

    @PostMapping
    public ResponseEntity<Reunion> createReunion(@RequestBody Reunion reunion) {
        Reunion savedReunion = reunionService.save(reunion);
        return ResponseEntity.ok(savedReunion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reunion> getReunionById(@PathVariable Long id) {
        return reunionService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReunion(@PathVariable Long id) {
        reunionService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
