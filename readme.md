# Spring Boot Task Management API – Learning Project

This project README is designed as a step-by-step learning guide and checklist for building a robust REST API using Spring Boot, Gradle, and best software engineering practices. By following this document, you'll learn foundational concepts, advanced coding practices, and build a fully working backend project with testing.

---

## Project Overview

**Project:** Task Management API  
**Summary:** A CRUD API to manage tasks and users, covering core Spring Boot concepts, interface design, clean code, validation, testing, and documentation.  
**Stack:** Java, Spring Boot, Gradle, H2/MySQL, JPA/Hibernate, REST, JUnit, Mockito  
**IDE:** IntelliJ IDEA

## Features

- User and Task domain models (CRUD for both)
- Input validation and error handling
- Service and repository layers using interfaces
- API documented with OpenAPI/Swagger
- Unit & integration testing with JUnit/Mockito
- In-memory H2 database support (switchable to MySQL)
- Clean code, modular structure, and best coding practices

## Architecture Overview

* Layered structure:
    - **Controller:** Handles HTTP requests/responses.
    - **DTO:** Data Transfer Objects for request/response bodies.
    - **Service:** Business logic, exposed via interfaces.
    - **Repository:** Data access via Spring Data JPA.
    - **Model/Entity:** JPA-annotated classes for database mapping.
    - **Exception:** Centralized exception handling (custom exceptions + `@ControllerAdvice`).
    - **Config:** Application-specific configurations (e.g., Swagger/OpenAPI, database).

## Steps to Implement the Project

### 1. Initialize the Project

- Use [Spring Initializr](https://start.spring.io/) to generate a project.
    - Build tool: **Gradle**
    - Add dependencies: Spring Web, Spring Data JPA, H2 Database, Lombok, Validation, Spring DevTools

### 2. Set Up Domain Models (Entities)

- Define `Task` and `User` as JPA entities
- Add relationships if needed (e.g., tasks "belong to" users)
- Use Lombok for boilerplate getters/setters

### 3. Create Repository Interfaces

- Extend `JpaRepository` for both `TaskRepository` and `UserRepository`
- Write custom finder methods if required

### 4. Implement DTOs

- Define request and response DTOs for both domain models

### 5. Service Layer
- Create interfaces (`TaskService`, `UserService`)
- Implement services (`TaskServiceImpl`, `UserServiceImpl`)
- Place all business logic here, not in controllers

### 6. Controller Layer

- Implement REST controllers using `@RestController`
- Map endpoints for CRUD operations
- Use DTOs in method signatures, not entities

### 7. Validation

- Apply Bean Validation annotations in DTOs (e.g., `@NotNull`, `@Size`)
- Validate input at controller layer

### 8. Exception Handling

- Create custom exceptions (e.g., `TaskNotFoundException`)
- Use `@ControllerAdvice` for global exception responses

### 9. Logging

- Add SLF4J logger to key classes (services/controllers)
- Log important actions and exceptions

### 10. Database Configuration

- Use H2 in-memory database for development
- Add `application.properties` for DB and JPA setup

### 11. Testing

- Write unit tests for services/controllers using JUnit 5
- Use Mockito for mocking dependencies
- Write integration tests to cover API endpoints

### 12. Documentation

- Integrate Swagger/OpenAPI for interactive API docs
- Document each endpoint with example payloads

### 13. Optional Enhancements

- Add pagination/sorting support
- Switch H2 to MySQL for production-level persistence
- Dockerize the application for deployment


---

## 1. Environment Setup

- [ ] Install Java JDK 17+  
- [ ] Install IntelliJ IDEA  
- [ ] Ensure Gradle support in IntelliJ  
- [ ] Install Postman (for API testing)

---

## 2. Project Initialization

- [ ] Generate via Spring Initializr (https://start.spring.io/)
    - Type: Gradle, Java
    - Dependencies: Spring Web, Spring Data JPA, H2 Database, Lombok, DevTools, Validation
- [ ] Import into IntelliJ (Open as Gradle project)
- [ ] Run with `./gradlew bootRun` to verify

---

## 3. Project Structure & Gradle

**Directory Layout:**
```
src/main/java/com/example/taskmanager/controller/service/repository/model/dto/config/exception/resources/application.propertiestest/java/com/example/taskmanager/service/controller/
```


**Gradle:**
- Explore `build.gradle` for plugins, dependencies, tasks

---

## 4. Domain & OOP Design

- [ ] Define `Task` and `User` models using JPA (`@Entity`, `@Id`)
- [ ] Use DTOs to avoid exposing entity details through REST API
- [ ] Create service interfaces (`ITaskService`, `IUserService`)
- [ ] Implement services (`TaskServiceImpl`, `UserServiceImpl`)
- [ ] Repository interfaces extend `JpaRepository` (e.g., `TaskRepository`)
- [ ] Organize by feature-based packaging

---

## 5. RESTful API Implementation

- [ ] CRUD Endpoints for `Task`, `User` (Create, Read, Update, Delete)
- [ ] Use proper HTTP methods and status codes
- [ ] Layered architecture: Controller → Service (interface) → Repository
- [ ] No business logic in controllers or repositories

---

## 6. Validation & Exception Handling

- [ ] Use Bean Validation (`@NotNull`, `@Size`, etc.) in DTOs/entities
- [ ] Centralized exception handling with `@ControllerAdvice` and custom exceptions
- [ ] Return meaningful error messages, never raw stack traces

---

## 7. Logging

- [ ] Use SLF4J logger in controllers and services
- [ ] Log important events, errors, and interactions

---

## 8. Persistence

- [ ] Use H2 (in-memory) for development/testing
- [ ] Optionally integrate MySQL for production configuration
- [ ] ORM mapping with JPA annotations, custom queries with JPQL if needed

---

## 9. Testing with JUnit & Mockito

- [ ] Write unit tests for services and controllers
- [ ] Use Mockito to mock dependencies in tests
- [ ] Cover both positive and negative cases

---

## 10. Documentation

- [ ] Document endpoints with Swagger/OpenAPI (springdoc-openapi)
- [ ] Write example requests/responses in this README
- [ ] Add API usage instructions

---

## 11. Optional/Advanced

- [ ] Pagination and sorting for `findAll` endpoints
- [ ] Basic security with Spring Security (JWT or simple login)
- [ ] Deploy using Docker or on the cloud

---

## 12. Best Practices Checklist

- [ ] All business logic in service layer (never in controllers/repositories)
- [ ] All service classes implement interfaces
- [ ] Use dependency injection everywhere (`@Autowired` or constructor injection)
- [ ] Avoid magic numbers/strings (use constants)
- [ ] Meaningful variable/method names, clean code, comments where necessary
- [ ] Transaction management in service layer (`@Transactional`)
- [ ] Proper error handling and logging
- [ ] Small, meaningful Git commits

---

## Example Endpoint List

| Method | Endpoint             | Description         |
|--------|----------------------|--------------------|
| POST   | /api/tasks           | Create new task    |
| GET    | /api/tasks/{id}      | Get task by ID     |
| PUT    | /api/tasks/{id}      | Update task        |
| DELETE | /api/tasks/{id}      | Delete task        |
| GET    | /api/tasks           | List all tasks     |

---

## References & Learning

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Data JPA Docs](https://spring.io/projects/spring-data-jpa)
- [Gradle Documentation](https://docs.gradle.org/current/userguide/userguide.html)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Spring Testing Guide](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing)

---
