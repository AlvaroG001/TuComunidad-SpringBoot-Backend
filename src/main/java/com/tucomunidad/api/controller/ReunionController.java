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

    @PostMapping
    public ResponseEntity<Reunion> createReunion(@RequestBody Reunion reunion) {
        return ResponseEntity.ok(reunionService.save(reunion));
    }

    @GetMapping
    public ResponseEntity<List<Reunion>> getReuniones(@RequestParam(required = false) String comunityId) {
        if (comunityId != null) {
            return ResponseEntity.ok(reunionService.findByComunityId(comunityId));
        }
        return ResponseEntity.ok(reunionService.findAll());
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
