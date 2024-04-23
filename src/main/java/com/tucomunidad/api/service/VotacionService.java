package com.tucomunidad.api.service;

import com.tucomunidad.api.model.Votacion;
import com.tucomunidad.api.repository.VotacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VotacionService {

    @Autowired
    private VotacionRepository votacionRepository;

    public Votacion save(Votacion votacion) {
        return votacionRepository.save(votacion);
    }

    public List<Votacion> findAll() {
        return votacionRepository.findAll();
    }

    public Optional<Votacion> findById(Long id) {
        return votacionRepository.findById(id);
    }

    public void deleteById(Long id) {
        votacionRepository.deleteById(id);
    }
}
