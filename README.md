# ToDo List Web API

This Java project is a Web API for managing a ToDo list. It is built with Spring Boot and uses MySQL as the database.

## Functionality

- Create new tasks
- Read existing tasks
- Update task details
- Delete tasks
- Mark tasks as completed
- Search tasks by various criteria

## Technologies Used

- Java
- Spring Boot
- MySQL
- Maven

## Database Setup

1. Install MySQL and create a new database named `{DB_NAME}`.
2. Update the `application.properties` file with your MySQL database settings:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:{YOUR_HOST}/{DB_NAME}
   spring.datasource.username={YOUR_USER}
   spring.datasource.password={YOUR_PASSWORD}
