# Movie Reservation System

## Overview

The Movie Reservation System is a Spring Boot application designed to manage movie reservations. It provides functionalities for managing users, movies, auditoriums, schedules, and reservations. The application uses an H2 in-memory database for development and testing purposes.

## Features

- User Management
  - Create, retrieve, and delete users.
- Movie Management
  - Add, retrieve, and delete movies.
- Auditorium Management
  - Create, retrieve, and delete auditoriums.
- Schedule Management
  - Create, retrieve, and delete schedules.
- Reservation Management
  - Create and manage reservations.
  - Add seats to reservations.
  - Retrieve occupied seats for a schedule.
  - Retrieve reservations by movie ID.

## Getting Started

### Prerequisites

- Java 21
- Maven 3.9.9

### Installation

1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd backend
   ```
2. Build the project:
   ```sh
   ./mvnw clean install
   ```
3. Run the application:
   ```sh
   ./mvnw spring-boot:run
   ```

### API Endpoints

#### User Endpoints

```http
Create User
POST /admin/users

Get All Users
GET /admin/users

Get User by ID
GET /admin/users/{id}

Delete User by ID
DELETE /admin/users/{id}
```

#### Movie Endpoints

```http
Add Movie
POST /admin/movie

Get All Movies
GET /admin/movies

Get Movie by ID
GET /admin/movie/{id}

Delete Movie by ID
DELETE /admin/movie/{id}
```

#### Auditorium Endpoints

```http
Create Auditorium
POST /admin/auditorium

Get All Auditoriums
GET /admin/auditoriums

Get Auditorium by ID
GET /admin/auditorium/{id}

Delete Auditorium by ID
DELETE /admin/auditorium/{id}
```

#### Schedule Endpoints

```http
Create Schedule
POST /admin/schedule

Get All Schedules
GET /admin/schedules

Get Schedule by ID
GET /admin/schedule/{id}

Delete Schedule by ID
DELETE /admin/schedule/{id}
```

#### Reservation Endpoints

```http
Get All Reservations
GET /user/reservations

Add Seats to Reservation
POST /user/reservations/{schedule_id}/add-seats

Get Occupied Seats
GET /user/reservations/{schedule_id}/occupied-seats

Get Reservations by Movie ID
GET /user/reservations/movie?movieId={movieId}
```
