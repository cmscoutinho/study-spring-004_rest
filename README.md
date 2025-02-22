# Java Spring REST API for Medical Appointments

## Overview

This project is a Spring Ecosystem-based REST API designed for managing appointments, doctors, patients, and authentication. It demonstrates how to structure a RESTful application while incorporating database migrations, validation, security, and custom exception handling.

## Features

- Doctor Management: CRUD operations for doctors.
- Patient Management: CRUD operations for patients.
- Appointment Scheduling: Book, cancel, and list appointments.
- User Authentication: Secure login and JWT-based authentication.
- Security: Implemented with Spring Security.
- Database Migrations: Versioned schema using Flyway.
- Validation: Custom and built-in validations.
- CORS Configuration: Cross-Origin Resource Sharing setup for frontend integration.

## Technologies

- Java: Version 17+
- Spring Boot: 3.x
- Spring Security: For securing endpoints.
- Flyway: Database versioning and migrations.
- H2 Database: In-memory database for development and testing.
- JWT: JSON Web Tokens for authentication.
- Maven: Dependency and build management.

## Requirements
- Java: JDK 17+
- Maven: 3.8+
- Installation

## Clone the repository:

```
git clone https://github.com/cmscoutinho/study-spring-004_rest
cd study-spring-004_rest-main
```

## Build the project:
`./mvnw clean install`

## Run the application:

`./mvnw spring-boot:run`

## Access the API at:
`http://localhost:8080`


## Endpoints

### Authentication
- `POST /auth/login` - Authenticate a user and receive a JWT.

### Doctors
- `POST /doctors` - Add a new doctor.
- `GET /doctors` - List all doctors.
- `GET /doctors/{id}` - Get details of a specific doctor.
- `PUT /doctors/{id}` - Update doctor information.
- `DELETE /doctors/{id}` - Deactivate a doctor.

### Patients
- `POST /patients` - Register a new patient.
- `GET /patients` - List all patients.
- `GET /patients/{id}` - Get details of a specific patient.
- `PUT /patients/{id}` - Update patient information.
- `DELETE /patients/{id}` - Deactivate a patient.

### Appointments
- `POST /appointments` - Schedule an appointment.
- `GET /appointments` - List all appointments.
- `DELETE /appointments/{id}` - Cancel an appointment.

## Database Migrations
The project uses Flyway for managing database schema migrations. SQL scripts are located in:

```src/main/resources/db/migration```


## Configuration
Modify the `application.properties` file to set your database and other configurations:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.flyway.enabled=true
jwt.secret=your_jwt_secret
```

## Testing

### Run tests with:

```./mvnw test```

## Contributing

- Fork the project.
- Create a feature branch.
- Commit your changes.
- Push to your branch.
- Open a Pull Request.

## License

- This project is licensed under the MIT License.
