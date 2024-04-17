package com.tucomunidad.api.repository;

import com.tucomunidad.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Aquí definimos el método que busca un usuario por email
    Optional<User> findByEmail(String email);
}
