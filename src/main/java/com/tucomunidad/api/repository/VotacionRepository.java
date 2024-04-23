package com.tucomunidad.api.repository;

import com.tucomunidad.api.model.Votacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotacionRepository extends JpaRepository<Votacion, Long> {
}
