package com.tucomunidad.api.service;

import com.tucomunidad.api.model.Reunion;
import com.tucomunidad.api.repository.ReunionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReunionService {

    @Autowired
    private ReunionRepository reunionRepository;

    public List<Reunion> findByCommunityId(Long communityId) {
        return reunionRepository.findByComunidad_Id(communityId);
    }

    public Reunion save(Reunion reunion) {
        return reunionRepository.save(reunion);
    }

    public List<Reunion> findAll() {
        return reunionRepository.findAll();
    }

    public Optional<Reunion> findById(Long id) {
        return reunionRepository.findById(id);
    }

    public void deleteById(Long id) {
        reunionRepository.deleteById(id);
    }
}
