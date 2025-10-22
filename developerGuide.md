# Spring Boot Task Management API - Developer Guide

### Endpoints

| Method | Endpoint                                | Description                        |
|--------|-----------------------------------------|------------------------------------|
| POST   | `/api/users`                            | Add new user                       |
| GET    | `/api/users`                            | List all users                     |
| GET    | `/api/users/{id}`                       | Get user by ID                     |
| PUT    | `/api/users/{id}`                       | Update user details                |
| DELETE | `/api/users/{id}`                       | Remove user                        |
| GET    | `/api/users/{id}/tasks`                 | List tasks assigned to a user      |
| POST   | `/api/tasks`                            | Add new task                       |
| GET    | `/api/tasks`                            | List all tasks                     |
| GET    | `/api/tasks/{id}`                       | Get task by ID                     |
| PUT    | `/api/tasks/{id}`                       | Update task details                |
| DELETE | `/api/tasks/{id}`                       | Delete task                        |
| POST   | `/api/tasks/{taskId}/assign/{userId}`   | Assign task to user                |
| GET    | `/api/external/quotes`                  | External API to get quotes         |
|--------| --------------------------------------- |------------------------------------|


---

### Database

- **Type:** H2 (in-memory, for development)
- **Configuration:** Set in `application.properties`
- **Access Console:** `http://localhost:8080/h2-console`

---

### Tables

- **User Table**
    - Columns: `id`, `name`, `email`, etc.
    - Primary Key: `id`

- **Task Table**
    - Columns: `id`, `title`, `description`, `status`, `priority`, `user_id` (foreign key)
    - Primary Key: `id`
    - Foreign Key: `user_id` references `User(id)`

- **Relationship:** One-to-many (one user can have multiple tasks)

---

### Other Key Points

- **Validation:** Bean Validation annotations in DTOs
- **Architecture:** Layered (Controller → Service → Repository → Model)
- **Testing:** Unit & integration tests (JUnit, Mockito)
- **Documentation:** Swagger/OpenAPI for API docs
- **Exception Handling:** Centralized with custom exceptions and `@ControllerAdvice`
- **Logging:** SLF4J in controllers/services

---

### Developer Tasks

- Set up project structure and dependencies
- Implement entities, DTOs, repositories, services, controllers
- Configure H2 and application properties
- Add validation, exception handling, logging
- Write tests and document endpoints