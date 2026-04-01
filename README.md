# 🎟️ Ticket Management System (Spring Boot)

## 📌 Overview

A RESTful backend application built using Spring Boot to manage users and support tickets.
This project demonstrates backend development using modern Java frameworks with proper architecture, validation, and database integration.

---

## 🚀 Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA (Hibernate)
* MySQL
* Maven
* Postman

---

## 🏗️ Architecture

The project follows a clean layered architecture:

* **Controller Layer** → Handles HTTP requests & responses
* **Service Layer** → Contains business logic
* **Repository Layer** → Database interaction using JPA
* **Entity Layer** → Maps Java objects to database tables

---

## ⚙️ Features

### 👤 User Management

* Create, Read, Update, Delete users
* Partial update support (only update required fields)
* Proper error handling for invalid user IDs

---

### 🎫 Ticket Management

* Create ticket with user validation
* Assign ticket to existing users
* Fetch all tickets and specific ticket by ID
* Entity relationships using `@ManyToOne`
* Automatic timestamps using `@PrePersist`

---

## 🔗 API Endpoints

### User APIs

* `POST /users` → Create user
* `GET /users` → Get all users
* `GET /users/{id}` → Get user by ID
* `PUT /users/{id}` → Update user
* `DELETE /users/{id}` → Delete user

### Ticket APIs

* `POST /api/tickets` → Create ticket
* `GET /api/tickets` → Get all tickets
* `GET /api/tickets/{id}` → Get ticket by ID

---

## 🧠 Key Concepts Implemented

* RESTful API design
* DTO pattern for request handling
* Entity relationships (`@ManyToOne`)
* Exception handling using `ResponseStatusException`
* Hibernate for ORM (Java → SQL conversion)
* Automatic auditing with lifecycle hooks

---

## 📈 In Progress / Improvements

* Update & delete ticket with business conditions
* Fetch tickets by user
* Use Enums for status & priority
* Global exception handling
* DTO responses for better API design

---

## 🎯 Learning Outcome

* Built REST APIs using Spring Boot
* Implemented layered backend architecture
* Worked with relational databases using JPA & Hibernate
* Applied real-world business logic and validation

---
