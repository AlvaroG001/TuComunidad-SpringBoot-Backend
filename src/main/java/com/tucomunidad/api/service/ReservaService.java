package com.tucomunidad.api.service;

import com.tucomunidad.api.model.Reserva;
import com.tucomunidad.api.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }

    public List<Reserva> findByInstalaciones(String instalaciones) {
        return reservaRepository.findByInstalaciones(instalaciones);
    }

    public boolean isTimeSlotAvailable(String instalaciones, java.util.Date startTime, java.util.Date endTime) {
        // Convertir java.util.Date a java.sql.Date
        java.sql.Date sqlStartTime = new java.sql.Date(startTime.getTime());
        java.sql.Date sqlEndTime = new java.sql.Date(endTime.getTime());

        List<Reserva> existingReservations = reservaRepository
                .findByInstalacionesAndStartTimeLessThanAndEndTimeGreaterThan(
                        instalaciones, sqlEndTime, sqlStartTime);
        return existingReservations.isEmpty(); // Devuelve true si no hay reservas que choquen
    }

}