package com.tucomunidad.api.service;

import com.tucomunidad.api.model.Usuario;
import com.tucomunidad.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return userRepository.findById(id);
    }

    public Usuario save(Usuario user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<Usuario> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
