package com.tucomunidad.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initialize() {
        insertCommunities();
        insertUsers();
        insertMeetings();
        insertVotaciones();
    }

    private void insertCommunities() {
        String sql = "INSERT INTO comunidades (name, cinema, gym, library, padel, pool) VALUES ('Comunidad Uno', true, false, true, false, true);";
        jdbcTemplate.execute(sql);
        String sql1 = "INSERT INTO comunidades (name, cinema, gym, library, padel, pool) VALUES ('Comunidad Dos', true, false, true, false, true);";
        jdbcTemplate.execute(sql1);
    }

    private void insertUsers() {
        String sql = "INSERT INTO usuarios (name, email, password, community_id, door, floor, is_president) VALUES ('Alvaro', 'alvaro@gmail.com', '1', 1, '1', '1', true);";
        jdbcTemplate.execute(sql);
    }

    private void insertMeetings() {
        String sql = "INSERT INTO reuniones (community_id, dia, hora, mes, año, information) VALUES (1, '21', '18:30', 'Mayo', '2024', 'Annual general meeting discussing community improvements and budget allocations.');";
        jdbcTemplate.execute(sql);
        String sql1 = "INSERT INTO reuniones (community_id, dia, hora, mes, año, information) VALUES (1, '21', '18:30', 'Mayo', '2024', 'Annual general meeting discussing community improvements and budget allocations.');";
        jdbcTemplate.execute(sql1);
        String sql2 = "INSERT INTO reuniones (community_id, dia, hora, mes, año, information) VALUES (1, '21', '18:30', 'Mayo', '2024', 'Annual general meeting discussing community improvements and budget allocations.');";
        jdbcTemplate.execute(sql2);
    }

    private void insertVotaciones() {
        String sql = "INSERT INTO votaciones (titulo, informacion, fecha, community_id) VALUES ('Votación  mejoras', 'Votación anual para discutir mejoras en la comunidad y asignaciones presupuestarias.', '2024-05-21 18:30:00', 1);";
        jdbcTemplate.execute(sql);
        String sql2 = "INSERT INTO votaciones (titulo, informacion, fecha, community_id) VALUES ('Votación  Pablo', 'Votación anual para discutir mejoras en la comunidad y asignaciones presupuestarias.', '2024-05-22 18:30:00', 1);";
        jdbcTemplate.execute(sql2);
        String sql3 = "INSERT INTO votaciones (titulo, informacion, fecha, community_id) VALUES ('Votación  Alvaro', 'Votación anual para discutir mejoras en la comunidad y asignaciones presupuestarias.', '2024-05-23 18:30:00', 1);";
        jdbcTemplate.execute(sql3);
    }
    
}
