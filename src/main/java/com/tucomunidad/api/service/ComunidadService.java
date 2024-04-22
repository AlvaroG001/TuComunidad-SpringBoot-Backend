package com.tucomunidad.api.service;

import com.tucomunidad.api.model.Comunidad;
import com.tucomunidad.api.repository.ComunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComunidadService {

    @Autowired
    private ComunidadRepository comunidadRepository;

    public List<Comunidad> findAll() {
        return comunidadRepository.findAll();
    }

    public Optional<Comunidad> findById(Long id) {
        return comunidadRepository.findById(id);
    }

    public Comunidad save(Comunidad comunidad) {
        return comunidadRepository.save(comunidad);
    }
}
