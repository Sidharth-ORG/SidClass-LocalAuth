📚 SidClass - Local Authentication
🚀 A Spring Boot-based Course Management System with Role-Based Access Control
SidClass is a backend application designed for managing courses, categories, videos, and users with secure local authentication. It features role-based authorization (Admin & Guest), file uploads, and custom exception handling, showcasing full-stack Java development with Spring Boot.

🛠️ Tech Stack
Java 17

Spring Boot 3.x

Spring Security (Basic Auth)

Spring Data JPA / Hibernate

MySQL Database

ModelMapper (for DTO mapping)

Swagger / OpenAPI (API Documentation)

🔑 Features
✔️ Authentication & Authorization – Local DB authentication with Basic Auth
✔️ Role-Based Access Control – Admin & Guest roles
✔️ CRUD APIs – Manage courses, categories, users, and videos
✔️ File Uploads – Upload and serve images/videos securely
✔️ Pagination & Sorting – Efficient data retrieval
✔️ Custom Exception Handling – Standardized API responses
✔️ Swagger Integration – Auto-generated API documentation

📂 Project Structure
bash
Copy
Edit
SidClass-LocalAuth
├── src/main/java/com/learn/SidClasses
│    ├── Configs/          # Security, Swagger, Project configurations
│    ├── Controller/       # REST API controllers
│    ├── Entities/         # JPA entities
│    ├── Repository/       # Data access layers
│    ├── Service/          # Business logic
│    ├── Security/         # Spring Security setup
│    └── SidClassesApplication.java
├── src/main/resources/
│    ├── templates/        # Login pages
│    ├── application.properties
├── pom.xml
└── README.md
🚀 Running the Project
1️⃣ Clone the repository
bash
Copy
Edit
git clone https://github.com/Sidharth-ORG/SidClass-LocalAuth.git
cd SidClass-LocalAuth
2️⃣ Configure Database
Update application.properties with your MySQL credentials:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/sidclass
spring.datasource.username=root
spring.datasource.password=yourpassword
3️⃣ Build & Run
bash
Copy
Edit
./mvnw spring-boot:run
4️⃣ Access APIs
Swagger UI → http://localhost:8080/swagger-ui.html

Login Page → http://localhost:8080/login

📌 Example APIs
POST /api/v1/users → Create a new user

GET /api/v1/courses → Get all courses (with pagination)

POST /api/v1/videos/{id}/videos → Upload video for a course

DELETE /api/v1/categories/{id} → Delete category

👨‍💻 Author
Sidharth Bhuyan

🏢 Java Backend Developer | Spring Boot | IAM | Security

📧 Email

🌐 LinkedIn

📝 License
This project is licensed under the Apache License 2.0.