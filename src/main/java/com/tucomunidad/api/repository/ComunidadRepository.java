package com.tucomunidad.api.repository;

import com.tucomunidad.api.model.Comunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunidadRepository extends JpaRepository<Comunidad, Long> {
}
