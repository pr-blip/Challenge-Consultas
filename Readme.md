<h1> Challenge de Consultas </h1>
# Proyecto Consultas sobre Tópicos

Este proyecto permite hacer consultas sobre tópicos específicos relacionados con problemas concretos. Está pensado para facilitar la gestión y búsqueda de información estructurada.

## Tecnologías usadas

- Java 17
- Spring Boot
- Spring Security con JWT
- JPA / Hibernate
- Base de datos MySQL
- Maven

## Funcionalidades principales

- Autenticación segura con tokens JWT.
- Endpoints para gestionar consultas sobre diferentes tópicos.
- Manejo de usuarios y roles para controlar acceso.
- Validación y manejo de errores centralizado.

## Cómo ejecutar el proyecto

```bash
./mvnw spring-boot:run
curl -X POST http://localhost:8080/login \
-H "Content-Type: application/json" \
-d '{"username":"tu_usuario", "password":"tu_password"}'

curl -X GET http://localhost:8080/api/consultas \
-H "Authorization: Bearer <tu_token_jwt>"
```
## Endpoints relevantes

### POST /login
Para autenticarse y recibir un token JWT.

### GET /recurso
Obtiene información del recurso. Requiere token válido.

### DELETE /recurso/{id}
Elimina un recurso específico por su ID. Requiere token válido.

### PUT /recurso/{id}
Actualiza un recurso específico por su ID. Requiere token válido.

Autor

Meyling Rojas 





