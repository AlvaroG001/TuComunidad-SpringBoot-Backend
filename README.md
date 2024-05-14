# TuComunidad-SpringBoot-Backend

## Descripción

TuComunidad es una aplicación web diseñada para facilitar la gestión y comunicación dentro de comunidades residenciales. Este proyecto representa el backend de la aplicación, desarrollado con Spring Boot. Proporciona servicios RESTful para gestionar usuarios, reuniones, votaciones, chats comunitarios y más.

## Características Principales

- **Gestión de Usuarios**: Registro, autenticación y gestión de perfiles de usuario.
- **Gestión de Reuniones**: Crear, leer, actualizar y eliminar reuniones comunitarias.
- **Sistema de Votaciones**: Crear y gestionar votaciones para la toma de decisiones comunitarias.
- **Chat Comunitario**: Comunicación en tiempo real entre los vecinos de la comunidad.
- **Seguridad**: Implementación de seguridad con Spring Security y JWT.

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para la creación de aplicaciones Java.
- **Spring Security**: Para la gestión de autenticación y autorización.
- **Spring Data JPA**: Para la interacción con la base de datos.
- **H2 Database**: Base de datos en memoria para desarrollo y pruebas.
- **JWT**: Para la autenticación basada en tokens.

## Instrucciones de Instalación

1. **Clonar el repositorio**:
    ```bash
    git clone https://github.com/AlvaroG001/TuComunidad-SpringBoot-Backend.git
    ```
2. **Configurar la base de datos**:
    - La configuración por defecto usa una base de datos H2 en memoria.
    - Para usar MySQL, actualiza `application.properties` con las credenciales de tu base de datos.

3. **Compilar y ejecutar la aplicación**:
    ```bash
    cd TuComunidad-SpringBoot-Backend
    mvn clean install
    mvn spring-boot:run
    ```

## Endpoints Principales

- **Usuarios**:
  - `POST /api/usuarios`: Registrar un nuevo usuario.
  - `POST /api/usuarios/auth`: Autenticar un usuario.

- **Reuniones**:
  - `GET /api/reuniones`: Obtener todas las reuniones.
  - `POST /api/reuniones`: Crear una nueva reunión.
  - `DELETE /api/reuniones/{id}`: Eliminar una reunión.

- **Votaciones**:
  - `GET /api/votaciones`: Obtener todas las votaciones.
  - `POST /api/votaciones`: Crear una nueva votación.
  - `POST /api/votaciones/{id}/vote`: Votar en una votación.
  - `DELETE /api/votaciones/{id}`: Eliminar una votación.

- **Chats**:
  - `GET /api/chats`: Obtener todos los chats.
  - `POST /api/chats`: Crear un nuevo chat.
  - `POST /api/chats/{id}/chat`: Actualizar un chat existente.
  - `DELETE /api/chats/{id}`: Eliminar un chat.

## Configuración

Configura el archivo `application.properties` para definir los parámetros de conexión a la base de datos y otras configuraciones específicas del entorno.

## Seguridad

El proyecto incluye configuración de seguridad con Spring Security. Las rutas de autenticación (`/login`, `/register`) están abiertas, mientras que las demás requieren autenticación.

## Contribuir

TuComunidad está abierto a contribuciones. Si tienes ideas para mejorar la aplicación o encuentras algún error, siéntete libre de crear un pull request o abrir un issue.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

---

**TuComunidad** es un proyecto diseñado para facilitar la gestión de comunidades y mejorar la interacción entre los vecinos. ¡Esperamos que encuentres útil esta aplicación!
