# AI Risk Register Project – Week 2 Updates

This document contains the implementation details for Day 7, Day 8, and Day 9 features of the AI Risk Register project.

---

## 📧 Day 7: Email Notifications (JavaMailSender + Thymeleaf)

### Features Implemented:
- Integrated Spring Boot Mail support using JavaMailSender
- Configured SMTP settings for Gmail
- Created EmailService for sending emails
- HTML email templates using Thymeleaf
- Email notifications triggered on:
  - Risk creation
  - Overdue risk alerts

### Configuration:
- SMTP host: smtp.gmail.com
- Port: 587
- Authentication enabled with App Password
- TLS enabled for secure communication

### Outcome:
System can automatically send email notifications when a new risk is created or when a risk becomes overdue.

---

## ⚠️ Day 8: Global Exception Handling

### Features Implemented:
- Created @RestControllerAdvice for centralized exception handling
- Handled:
  - RiskNotFoundException (404)
  - Validation errors (400)
  - Generic exceptions (500)
- Standardized JSON error response format

### Response Structure:
- timestamp
- status
- error
- message

### Outcome:
All API errors return consistent and structured JSON responses.

---

## 📁 Day 9: File Attachment Management

### Features Implemented:
- File upload API: POST /files/upload
- File retrieval API: GET /files/{id}
- File validation:
  - Maximum file size: 10MB
- UUID-based file naming for uniqueness
- Files stored in local server directory (uploads/)
- File metadata stored in database using JPA

### Technical Implementation:
- MultipartFile used for file upload
- Java UUID used for unique filenames
- Local file system storage configured using project directory path

### Outcome:
Users can upload and retrieve files securely with proper validation and storage handling.

---

## 🚀 Overall Progress

- Day 1–6: Core REST APIs, Security, Redis caching
- Day 7: Email notification system
- Day 8: Global exception handling
- Day 9: File upload and management system

---

## ✅ Status
Project is progressing successfully with all core backend features implemented.
