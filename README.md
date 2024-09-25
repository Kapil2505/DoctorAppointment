# Doctor Appointment System

A fully functional Doctor Appointment Booking System built using Java, Spring Boot, Hibernate, and MySQL. This project facilitates the scheduling of appointments between patients and doctors, along with real-time availability and booking management.

## Table of Contents
1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Installation](#installation)
4. [Configuration](#configuration)
5. [Usage](#usage)
6. [API Documentation](#api-documentation)
7. [Contributing](#contributing)

## Features
- Patient and doctor registration and login.
- Real-time doctor availability for appointments.
- Booking, cancelling, and rescheduling appointments.
- Secure authentication with JWT tokens.
- Notifications via email for appointment confirmations and reminders.
- Comprehensive API documentation using Swagger.

## Technologies Used
- **Java**
- **Spring Boot**: For building RESTful services.
- **Hibernate**: For ORM and database management.
- **MySQL**: Database for storing application data.
- **Spring Security**: JWT-based authentication and authorization.
- **Swagger**: API documentation and testing.
- **iText PDF**: For generating appointment summaries (if applicable).
- **Email Service**: For sending notifications.

## Installation

### Prerequisites:
- Java 8 or higher
- Maven
- MySQL database

### Steps to Set Up the Project:
1. Clone the repository:
    ```bash
    git clone https://github.com/Kapil2505/DoctorAppointment.git
    cd DoctorAppointment
    ```

2. Configure database settings in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/doctor_appointment
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```

3. Build the project:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Configuration
Set up environment variables for email and JWT authentication:

```bash
MAIL_USERNAME=your-email
MAIL_PASSWORD=your-email-password
JWT_SECRET=your-jwt-secret

## Usage
Once the application is up and running, you can access it via `http://localhost:8080`.

### User Workflows:
- **Patient Registration and Login**: Patients can sign up and log in to book an appointment.
- **Doctor Registration and Login**: Doctors can register and manage their availability.
- **Book an Appointment**: Patients can check doctor availability and book appointments.
- **Cancel or Reschedule an Appointment**: Patients can modify their bookings.
- **Receive Notifications**: Email notifications are sent for confirmations and reminders.

## API Documentation
Swagger API documentation is automatically generated and available once the application is running. To view and test the APIs:

1. Open your browser.
2. Navigate to `http://localhost:8080/swagger-ui/`.

## API Endpoints

Here is a list of important API endpoints:

### Authentication:
- **Patient Registration**: 
    ```
    POST /api/patients/register
    ```
    Registers a new patient.

- **Doctor Registration**: 
    ```
    POST /api/doctors/register
    ```
    Registers a new doctor.

- **User Login**: 
    ```
    POST /api/login
    ```
    Authenticates the user and returns a JWT token.

### Appointment Management:
- **Book an Appointment**: 
    ```
    POST /api/appointments/book
    ```
    Books an appointment with a doctor.

- **Cancel an Appointment**: 
    ```
    DELETE /api/appointments/cancel/{appointmentId}
    ```
    Cancels an appointment.

- **Reschedule an Appointment**: 
    ```
    PUT /api/appointments/reschedule/{appointmentId}
    ```
    Reschedules an existing appointment.

### Doctor Availability:
- **Check Doctor Availability**:
    ```
    GET /api/doctors/availability/{doctorId}
    ```
    Retrieves available time slots for a doctor.

## Contributing
1. Fork the repository.
2. Create a new branch:
    ```bash
    git checkout -b feature-branch
    ```
3. Commit your changes:
    ```bash
    git commit -m 'Add feature'
    ```
4. Push to the branch:
    ```bash
    git push origin feature-branch
    ```
5. Open a pull request.

 
