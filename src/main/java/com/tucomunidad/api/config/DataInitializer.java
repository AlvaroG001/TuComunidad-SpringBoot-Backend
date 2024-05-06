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
        insertChats();
        insertReservations();
    }

    private void insertCommunities() {
        String sql = "INSERT INTO comunidades (name, cinema, gym, library, padel, pool) VALUES ('C. Sajonia Nº9', true, false, true, true, false);";
        jdbcTemplate.execute(sql);
        String sql1 = "INSERT INTO comunidades (name, cinema, gym, library, padel, pool) VALUES ('C. Sajonia Nº9', true, false, true, false, true);";
        jdbcTemplate.execute(sql1);
        String sql2 = "INSERT INTO comunidades (name, cinema, gym, library, padel, pool) VALUES ('Comunidad del administrador', false, false, false, false, false);";
        jdbcTemplate.execute(sql2);
    }

    private void insertUsers() {
        String sql = "INSERT INTO usuarios (name, email, password, community_id, door, floor, is_president, is_admin) VALUES ('Álvaro', 'alvaro@gmail.com', 'A123', 1, '1', '1', true, false);";
        jdbcTemplate.execute(sql);
        String sql1 = "INSERT INTO usuarios (name, email, password, community_id, door, floor, is_president, is_admin) VALUES ('David', 'david@gmail.com', 'A123', 1, '1', '1', false, false);";
        jdbcTemplate.execute(sql1);
        String sql2 = "INSERT INTO usuarios (name, email, password, community_id, door, floor, is_president, is_admin) VALUES ('Administrador', 'administrador@gmail.com', 'A123', 3, '1', '1', true, true);";
        jdbcTemplate.execute(sql2);
    }

    private void insertMeetings() {
        String sql = "INSERT INTO reuniones (community_id, titulo, dia, hora, mes, año, information) VALUES (1, 'Reunión primer trimestre del año 2024', '1', '18:30', 'Julio', '2024', 'Información sobre la primera reunión del trimestre del año 2024');";
        jdbcTemplate.execute(sql);
        String sql1 = "INSERT INTO reuniones (community_id, titulo, dia, hora, mes, año, information) VALUES (1, 'Asamblea general', '10', '18:30', 'Junio', '2024', 'Asamblea general extraordinaria para tratar temas urgentes y tomar decisiones excepcionales');";
        jdbcTemplate.execute(sql1);
        String sql2 = "INSERT INTO reuniones (community_id, titulo, dia, hora, mes, año, information) VALUES (1, 'Sesión de planificación de eventos', '20', '18:30', 'Mayo', '2024', 'Sesión de planificación de eventos para organizar actividades comunitarias y festividades');";
        jdbcTemplate.execute(sql2);
        String sql3 = "INSERT INTO reuniones (community_id, titulo, dia, hora, mes, año, information) VALUES (1, 'Revisión Anual de Seguridad', '10', '19:00', 'Mayo', '2024', 'Reunión anual para revisar las políticas de seguridad de la comunidad, discutir incidentes del último año y proponer mejoras en las medidas de seguridad actuales.');";
        jdbcTemplate.execute(sql3);
    }

    private void insertVotaciones() {
        String sql = "INSERT INTO votaciones (titulo, informacion, fecha, community_id) VALUES ('Reformas en la piscina', 'Se propone realizar una serie de reformas en la piscina comunitaria para mejorar su seguridad, comodidad y estética. Estas reformas incluyen la renovación del pavimento alrededor de la piscina, la instalación de nuevas duchas y vestuarios, así como la mejora del sistema de filtrado y limpieza del agua. Además, se contempla la posibilidad de añadir nuevas características, como toboganes o zonas de juegos acuáticos, para aumentar el atractivo de la piscina para todos los residentes. ¡Tu opinión es importante para decidir el futuro de nuestras instalaciones comunitarias!', '2024-05-21 18:30:00', 1);";
        jdbcTemplate.execute(sql);
        String sql2 = "INSERT INTO votaciones (titulo, informacion, fecha, community_id) VALUES ('Pintar garaje', 'Se propone realizar una votación para decidir si se debe pintar el garaje comunitario. El garaje es un espacio compartido por todos los residentes y su apariencia juega un papel importante en la impresión general de nuestra comunidad. La pintura actual puede estar desgastada o descolorida, y una nueva capa de pintura podría mejorar significativamente la estética y la calidad general del garaje. La votación determinará si los residentes están de acuerdo en asignar fondos para este proyecto de mejora del garaje comunitario. ¡Tu voto cuenta para decidir el futuro aspecto de nuestro garaje!', '2024-05-22 18:30:00', 1);";
        jdbcTemplate.execute(sql2);
        String sql3 = "INSERT INTO votaciones (titulo, informacion, fecha, community_id) VALUES ('Instalar telefonillo con camaras', 'Esta votación tiene como objetivo decidir si la comunidad desea instalar un telefonillo con cámara en la entrada principal del edificio. La instalación de un telefonillo con cámara proporcionará un nivel adicional de seguridad al permitir a los residentes ver y comunicarse con los visitantes antes de permitirles el acceso al edificio. Este sistema puede ayudar a prevenir la entrada de personas no autorizadas y mejorar la tranquilidad de los residentes.', '2024-05-23 18:30:00', 1);";
        jdbcTemplate.execute(sql3);
        String sql4 = "INSERT INTO votaciones (titulo, informacion, fecha, community_id) VALUES ('Renovación del área de juegos infantiles', 'Esta votación busca recoger la opinión de la comunidad sobre la propuesta de renovar el área de juegos infantiles. La renovación incluiría la instalación de nuevos juegos seguros y modernos, reparación del suelo amortiguante, y la adición de bancos para que los padres puedan supervisar a sus hijos cómodamente. Este proyecto tiene como objetivo proporcionar un espacio seguro y divertido para el disfrute de los niños de nuestra comunidad.', '2024-06-15 17:00:00', 1);";
        jdbcTemplate.execute(sql4);
    }

    private void insertChats() {
        String sql = "INSERT INTO chats (sender, message, fecha, community_id, titulo) VALUES ('Alvaro', 'Estamos buscando una pareja para jugar un partido de padel, la idea es jugar el partido este proximo fin de semana ¿Alguien interesado?', '2022-05-01T12:30:00', 1, 'Partido de padel')";
        jdbcTemplate.execute(sql);
        String sql2 = "INSERT INTO chats (sender, message, fecha, community_id, titulo) VALUES ('David', '¡Hola vecino! Bienvenido a nuestra aplicación comunitaria. Aquí podrás conectarte con tus vecinos, compartir información importante y participar en conversaciones que afectan a nuestra comunidad. Únete a nosotros para mantenernos informados, colaborar juntos y hacer de nuestro vecindario un lugar aún mejor para vivir. ¡Es un placer tenerte aquí!', '2022-05-01T10:15:00', 1, '¡Bienvenido a la Comunidad!')";
        jdbcTemplate.execute(sql2);
        String sql3 = "INSERT INTO chats (sender, message, fecha, community_id, titulo) VALUES ('Pablo', '¡Estáis invitados al día de inauguración de nuestra comunidad! Únanse a nosotros en una comida en nuestro local comunitario para conocerse, compartir risas y comenzar una relación vecinal sólida y positiva. ¡No se lo pierdan! ¡Esperamos verlos allí!', '2022-04-01T10:15:00', 1, 'Inaguración de la comunidad')";
        jdbcTemplate.execute(sql3);
        String sql4 = "INSERT INTO chats (sender, message, fecha, community_id, titulo) VALUES ('Jaime', 'Recordatorio: No olviden que este sábado tendremos nuestra limpieza comunitaria anual. Será una excelente oportunidad para contribuir a nuestra comunidad y también para socializar. ¡Traigan guantes y buena energía!', '2022-05-20T09:00:00', 1, 'Limpieza Comunitaria Anual')";
        jdbcTemplate.execute(sql4);
    }

    private void insertReservations() {
        String sql = "INSERT INTO reservas (title, start_time, end_time, instalaciones) VALUES ('Álvaro', '2024-05-06 16:00:00', '2024-05-06 17:00:00', 'cinema'), ('Pablo', '2024-05-06 18:00:00', '2024-05-06 20:00:00', 'cinema')";
        jdbcTemplate.execute(sql);
        String sql1 = "INSERT INTO reservas (title, start_time, end_time, instalaciones) VALUES ('Pablo', '2024-05-05 17:00:00', '2024-05-05 18:00:00', 'padel'), ('Pablo', '2024-05-05 18:00:00', '2024-05-05 19:00:00', 'padel')";
        jdbcTemplate.execute(sql1);
    }

}
