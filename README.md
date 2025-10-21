# Bookstore

Revisiting core Spring Framework concepts by building a simple Bookstore web application. This project follows along with the Spring Framework Guru tutorial and demonstrates a full-stack Spring Boot app with data persistence and a server‑side rendered UI.

![](https://img.shields.io/badge/Editor-IntelliJ-informational?style=flat&logo=intellij-idea)
![](https://img.shields.io/badge/Code-Java_8-informational?style=flat&logo=java)
![](https://img.shields.io/badge/Framework-Spring_Boot_2.2-informational?style=flat&logo=spring)
![](https://img.shields.io/badge/Build-Maven-informational?style=flat&logo=apache-maven)

---

## Table of Contents
- Overview
- Features
- Tech Stack
- Getting Started
  - Prerequisites
  - Build
  - Run
- Application Endpoints
- Data Model
- Development Notes
- Troubleshooting

## Overview
A minimal Spring Boot web app that manages Books, Authors, and Publishers. It uses Spring Data JPA with an in‑memory H2 database and Thymeleaf to render HTML pages. On startup, the app seeds sample data so you can explore the UI immediately.

## Features
- List all books and authors via a simple web UI
- Server‑side rendered pages with Thymeleaf templates
- Spring Data JPA repositories backed by H2 (in‑memory) database
- Automatic sample data loading at startup
- H2 Console enabled for quick database inspection

## Tech Stack
- Java 8
- Spring Boot 2.2.x
  - Spring Web (MVC)
  - Spring Data JPA
  - Thymeleaf
- H2 Database (in‑memory)
- Maven (with Maven Wrapper included)

## Getting Started

### Prerequisites
- Java 8 (JDK 1.8)
- Git (to clone the repository)
- You may use the Maven Wrapper included in the project; no separate Maven installation required.

### Build
On Windows PowerShell or Command Prompt from the project root:

- Using Maven Wrapper:
  - `mvnw.cmd clean package`

- If Maven is installed and on your PATH:
  - `mvn clean package`

### Run
Run the application from the project root using one of the following options:

- Using Maven Wrapper (recommended during development):
  - `mvnw.cmd spring-boot:run`

- Running the packaged JAR (after build):
  - `java -jar target\spring5webapp-2.2.2.jar`

Once started, open your browser at:
- Books: http://localhost:8080/books
- Authors: http://localhost:8080/authors
- H2 Console: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:testdb`
  - User Name: `sa` (default)
  - Password: (leave blank by default)

## Application Endpoints
- GET /books → Displays a list of books
- GET /authors → Displays a list of authors
- GET /h2-console → H2 database console (enabled via `spring.h2.console.enabled=true`)

## Data Model
Core entities can be found under `src\main\java\guru\springframework\spring5webapp\domain`:
- `Author` — first name, last name; many‑to‑many with `Book`
- `Book` — title, ISBN; many‑to‑many with `Author`, many‑to‑one with `Publisher`
- `Publisher` — name and address; one‑to‑many with `Book`

Initial sample data is populated on startup by `BootStrapData` under `bootstrap/`.

## Development Notes
- Templates are located under `src\main\resources\templates` with separate folders for `books` and `authors`.
- This project is intentionally minimal and educational, focusing on the basics of Spring Boot MVC, JPA, and Thymeleaf.

## Troubleshooting
- Port already in use: Change the port with `server.port=8081` in `src\main\resources\application.properties`.
- H2 Console not loading: Ensure the app is running and navigate to `/h2-console`; verify JDBC URL is `jdbc:h2:mem:testdb`.
- Build issues: Confirm you are using Java 8 and run a clean build: `mvnw.cmd clean package`.
