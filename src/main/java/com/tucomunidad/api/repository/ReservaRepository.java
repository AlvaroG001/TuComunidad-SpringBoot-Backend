package com.tucomunidad.api.repository;

import com.tucomunidad.api.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByInstalaciones(String instalaciones);

    List<Reserva> findByInstalacionesAndStartTimeLessThanAndEndTimeGreaterThan(String instalaciones, Date endTime,
            Date startTime);

}
