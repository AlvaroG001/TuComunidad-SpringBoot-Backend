package com.tucomunidad.api.controller;

import com.tucomunidad.api.model.Reserva;
import com.tucomunidad.api.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> getReservas(@RequestParam(required = false) String instalaciones) {
        if (instalaciones != null && !instalaciones.isEmpty()) {
            return ResponseEntity.ok(reservaService.findByInstalaciones(instalaciones));
        } else {
            return ResponseEntity.ok(reservaService.findAll());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        reservaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> createReserva(@RequestBody Reserva reserva) {
        if (!reservaService.isTimeSlotAvailable(reserva.getInstalaciones(), reserva.getStartTime(),
                reserva.getEndTime())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("No se puede reservar porque el horario ya está ocupado.");
        }
        Reserva savedReserva = reservaService.save(reserva);
        return ResponseEntity.ok(savedReserva);
    }

}