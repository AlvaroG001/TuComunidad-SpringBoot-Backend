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

    public List<Votacion> findByCommunityId(Long communityId) {
        return votacionRepository.findByComunidad_Id(communityId);
    }

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
    
    public Votacion updateVotacion(Long votacionId, Votacion votacion) {
        return votacionRepository.findById(votacionId).map(existingVotacion -> {
            existingVotacion.setTitulo(votacion.getTitulo());
            existingVotacion.setInformacion(votacion.getInformacion());
            existingVotacion.setFecha(votacion.getFecha());
            existingVotacion.setVotantes(votacion.getVotantes());
            existingVotacion.setRespuestas(votacion.getRespuestas());
            return votacionRepository.save(existingVotacion);
        }).orElse(null);
    }
}
