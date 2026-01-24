# Esports Tournament Management System

This project is a simple Java application created for Assignment 3.  
It simulates an esports tournament system using Java, JDBC, and PostgreSQL.

The main idea is to practice working with databases, clean project structure, and object-oriented design.

---

## What this project does
- Manages teams
- Manages games
- Creates tournaments for specific games
- Creates matches between teams
- Stores all data in a PostgreSQL database

---

## Project structure (short explanation)

- **Controller** – handles interaction and output
- **Service** – contains logic and validation
- **Repository** – works with the database using JDBC
- **Model** – application entities (Team, Game, Tournament, Match)
- **Exception** – custom exceptions for errors
- **Utils** – database connection

---

## Database
- PostgreSQL
- JDBC with `PreparedStatement`
- Database name: `esports_db`

Tables are created using `schema.sql`.

---

## How to run
1. Create database `esports_db`
2. Run `schema.sql`
3. Add PostgreSQL JDBC driver
4. Run `Main.java`

---

## Notes
The project focuses on correct architecture and clear separation of responsibilities rather than UI.

---

