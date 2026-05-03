### Day 1 - Project Setup
- Created Spring Boot project
- Added dependencies (Spring Web, JPA, Security, etc.)
- Configured application.properties

### Day 2 - Database Setup
- Created Risk entity
- Configured MySQL connection
- Set up repository layer using JPA

### Day 3 - Service Layer
- Implemented service classes
- Added business logic for risk management
- Basic CRUD operations preparation
# AI Risk Register Project

## Overview
Spring Boot project built during internship to manage risks with REST APIs, JWT authentication, and Redis caching.

## Completed Work

### Day 4 - REST APIs
- GET all risks (pagination)
- GET by ID with 404 handling
- POST create risk
- Exception handling

### Day 5 - JWT Authentication
- Login with JWT token
- Secured APIs using authentication filter

### Day 6 - Redis Caching
- @Cacheable for GET APIs
- @CacheEvict for updates
- Improved performance using Redis

## Tech Stack
Java, Spring Boot, Spring Security, JWT, Redis, MySQL

### 📧 Day 7 – Email Notifications
- Implemented *JavaMailSender*
- Used *Thymeleaf HTML templates*
- Email sent on:
  - Risk creation
  - Overdue risk events

---

### ⚠️ Day 8 – Global Exception Handling
- Implemented @ControllerAdvice
- Handled:
  - ResourceNotFoundException (404)
  - ValidationException (400)
  - Generic Exception (500)
- Standardized JSON error response format

---

### 📁 Day 9 – File Upload Feature
- Implemented file upload API:
  - POST /upload
  - GET /files/{id}
- Validated:
  - File type
  - File size (< 10 MB)
- Stored files using UUID naming system

---

### 🧪 Day 10 – Unit Testing (JUnit + Mockito)
- Created 10+ unit tests for service layer
- Covered:
  - Happy path scenarios
  - Error scenarios
- Used Mockito for mocking dependencies

---

### 📊 Day 11 – Code Coverage Testing
- Added additional tests to reach ~80% coverage
- Used:
  - @DataJpaTest for repository layer
  - Controller and utility testing (AuthController, JwtUtil, AuditService)

---

### 📘 Day 12 – Swagger API Documentation
- Integrated Swagger/OpenAPI
- Added:
  - @Operation
  - @ApiResponse
- Documented all APIs with examples

---

### 🐳 Day 13 – Full System Testing (Docker)
- Used Docker Compose for testing
- Commands:
  - docker-compose down -v
  - docker-compose up --build
- Performed full end-to-end system testing

---

### 🌱 Day 14 – Data Seeder
- Created DataLoader
- Auto-seeded *30 realistic risk records*
- Covered multiple:
  - Risk statuses
  - Severity levels
  - Score ranges

---

### 👥 Day 15 – Code Review & Standards
- Performed full team code review
- Ensured:
  - No hardcoded secrets
  - No TODO comments
  - Clean coding standards followed
- Improved project maintainability

---

### 📖 Day 16 – Final README & Documentation
- Created final README.md
- Added:
  - Project overview
  - Setup instructions
  - Architecture explanation
  - Environment configuration reference

---

## 🏗️ Architecture
