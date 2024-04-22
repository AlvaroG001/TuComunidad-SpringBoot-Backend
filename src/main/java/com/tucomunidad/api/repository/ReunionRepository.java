package com.tucomunidad.api.repository;

import com.tucomunidad.api.model.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReunionRepository extends JpaRepository<Reunion, Long> {
    List<Reunion> findByComunidad_Id(Long communityId);
}
