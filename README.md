# JPA Many-to-Many Relationship Demo

This project demonstrates a JPA implementation of a many-to-many relationship between Student and Course entities using Jakarta Persistence API.

## Project Overview

This application showcases:
- JPA entity mappings with bidirectional many-to-many relationship
- Data Access Objects (DAO) pattern implementation
- CRUD operations using Jakarta Persistence API
- MySQL database integration

## Structure

- **Models**: Student and Course entities with a bidirectional many-to-many relationship
- **DAO Interfaces**: Defining standard CRUD operations
- **DAO Implementations**: Concrete implementations using JPA EntityManager
- **Main Class**: Demo application showing entity creation, relationship management, and queries

## Technologies Used

- Java
- Jakarta Persistence API (JPA)
- EclipseLink (JPA implementation)
- MySQL
- Maven

## Setup

1. Create a MySQL database named `entity4`
2. Configure database credentials in `persistence.xml` if needed
3. Build the project with Maven:
   ```
   mvn clean install
   ```
4. Run the `MainClass`

## Key Concepts

### Many-to-Many Relationship

The project demonstrates:
- Bidirectional many-to-many relationship between Student and Course
- Proper relationship ownership with `@JoinTable` and `mappedBy` attributes
- Relationship management with helper methods

### DAO Pattern

- Clear separation between interfaces and implementations
- Consistent transaction handling
- Resource management with proper close methods

## Database Schema

- `students` table: Stores student information
- `courses` table: Stores course information
- `student_course` table: Join table managing the many-to-many relationship
