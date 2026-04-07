# 🎟️ Ticket Management System (Spring Boot)

## 📌 Overview
A RESTful backend application built using Spring Boot to manage users and support tickets.  
Implements layered architecture, DTO pattern, validation, and production-style API design.

---

## 🚀 Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- Postman

---

## 🏗️ Architecture
Controller → Service → Repository → Database

---

## ⚙️ Features

### 👤 User Management
- Full CRUD operations
- Partial updates
- Proper validation for invalid user IDs

### 🎫 Ticket Management
- Create and assign tickets to users
- Fetch, update, and soft delete tickets
- Filter tickets by:
    - Status
    - Priority
    - Created user
    - Assigned user
- Entity relationships using `@ManyToOne`
- Automatic timestamps using `@PrePersist` & `@PreUpdate`

---

## 🔗 API Endpoints

### User APIs
- POST `/api/users`
- GET `/api/users`
- GET `/api/users/{id}`
- PUT `/api/users/{id}`
- DELETE `/api/users/{id}`

### Ticket APIs
- POST `/api/tickets`
- GET `/api/tickets`
- GET `/api/tickets/{id}`
- PUT `/api/tickets/{id}`
- DELETE `/api/tickets/{id}`

### Filters
- GET `/api/tickets/status/{status}`
- GET `/api/tickets/priority/{priority}`
- GET `/api/tickets/created-by/{id}`
- GET `/api/tickets/assigned-to/{id}`

---

## 🧠 Key Concepts Implemented
- RESTful API design
- DTO pattern
- Layered architecture
- JPA entity relationships (`@ManyToOne`)
- Soft delete implementation
- Input validation (status & priority)
- Centralized exception handling (`@ControllerAdvice`)
- Lifecycle hooks for auditing

---

## ⚠️ Valid Values
- Status: OPEN, IN_PROGRESS, RESOLVED
- Priority: LOW, MEDIUM, HIGH

---

## 🧪 Testing
Tested using Postman for all endpoints.

---

## 📈 Future Improvements
- JWT Authentication
- Pagination & sorting
- Frontend integration (React)

---

## 🎯 Learning Outcome
- Built scalable REST APIs using Spring Boot
- Implemented clean backend architecture
- Applied validation and exception handling
- Designed real-world API features and workflows