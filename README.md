# Book REST API

Spring Boot project for Book REST API.

This project is very simple and it is intended to show some architectural and implementation practices.

## Practices

Some practices:
- Use of Spring Boot.
- Use of JPA/Hibernate to handle database connection.
- Usage of JpaRepository as DAO layer.
- Separation of concerns: usage of Service layer to connect REST and DAO.
- Use of Spring Security with JDBC stored users/authorities.
- Hashing of database-saved passwords.

## Run

To run the application, a database is needed.

In the directory `mysql`, one can find a YAML file for running a MySQL database, which is accessbile using Adminer as a UI
on port 8088. Docker is needed for these to be run.

Just execute:
```bash
docker compose -f mysql-adminer.yml up -d
```

After accessing the dockerized database with the provided credentials, one can execute the scripts provided in the `sql-scripts` 
directory in the order indicated by the initial numbers. This will create a database structure to test the application.

The application can be built and run with the Maven wrapper provided in the repository:
```bash
./mvnw clean package
./mvnw spring-boot:run
```