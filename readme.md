ESports Tournament Management System – README
A. SOLID Documentation

1. SRP (Single Responsibility Principle)

Each class in the project has a single responsibility:

GameController handles game-related HTTP-like requests.

GameService contains business logic (validation, creation rules).

GameRepository manages database persistence only.

Similarly, Player, Team, Tournament, and Match each have focused responsibilities.

2. OCP (Open/Closed Principle)

Classes are open for extension but closed for modification.

Example: Game base class has subclasses Moba and Fps.

Adding a new game type (e.g., BattleRoyale) does not require changing existing code.

3. LSP (Liskov Substitution Principle)

Subclasses can replace the base class without breaking the code.

Moba and Fps can be used anywhere a Game object is expected (e.g., tournaments, match scheduling).

Polymorphic operations on Game work without conditional checks.

4. ISP (Interface Segregation Principle)

Interfaces are narrow and focused:

CrudRepository only contains CRUD methods.

Specialized repositories (like MatchRepository) add extra methods without forcing unrelated classes to implement them.

5. DIP (Dependency Inversion Principle)

Services depend on abstractions, not concrete classes.

All services receive repositories via constructor injection.

This allows for easier testing and decouples service logic from database implementations.

B. Advanced OOP Features

1. Generics

JdbcCrudRepository<T> is generic, allowing reuse across multiple entities (Game, Team, Player).

2. Lambdas

Used in controllers/services for filtering and sorting lists.

Example: displaying all players in a team sorted by score or age.

3. Reflection

Implemented to inspect entity fields dynamically, useful for generic CRUD operations or debugging entity metadata.

4. Interface Default/Static Methods

Default methods in CrudRepository provide common functionality (e.g., getById).

Static methods used for utility functions, like connection validation or logging.

C. OOP Documentation

1. Abstract Class + Subclasses

Game is abstract. Subclasses: Moba, Fps.

Allows polymorphic behavior in tournaments and matches.

2. Composition Relationships

Tournament has a Game (composition).

Match contains references to Team and Tournament objects.

Team has a list of Player objects.

3. Polymorphism Examples

Tournaments store Game objects without knowing the specific subclass.

playMatch() uses polymorphism to calculate random scores regardless of game type.

4. UML Diagram

Shows inheritance (Game -> Moba/Fps)

Composition (Tournament -> Game, Team -> Player, Match -> Team + Tournament)

Interfaces (CrudRepository implemented by repositories)

D. Database Section

1. Schema

Tables: games, teams, players, tournaments, matches.

2. Constraints

Primary keys on all tables.

Foreign keys:

players.team_id -> teams.id

matches.team1_id/team2_id -> teams.id

matches.tournament_id -> tournaments.id

Constraints enforce integrity, prevent orphan records.

3. Sample Inserts

Games: "Dota 2", "CS:GO"

Teams: "Team Alpha", "Team Bravo"

Players: "Allan", "Plasha"

Tournament: "Winter Cup"

Matches: random scores, linked teams and tournament.

E. Architecture Explanation

1. Controller Layer

Receives input (user commands in Main).

Calls corresponding service methods.

Handles success/failure messages.

2. Service Layer

Contains business logic, validations, and rules.

Interacts with repositories for persistence.

3. Repository Layer

Directly handles database operations.

Generic JdbcCrudRepository used for all entities.

Implements save, findById, findAll, deleteById.

4. Request/Response Behavior

Example: creating a match:

Controller receives Match object.

Service validates teams and tournament.

Repository saves to DB.

Controller prints success/failure to console.

F. Execution Instructions

1. Requirements

Java 25+

PostgreSQL database with the provided schema

JDBC driver in classpath

2. Compile and Run

Compile: javac -d out/production <all_java_files>

Run: java -cp out/production;postgresql-42.7.4.jar Main

Ensure database connection parameters match DatabaseConnection class.

G. Screenshots

1. Successful CRUD Operations

Creating and listing games, teams, players, tournaments, matches.

2. Validation Failures

Player creation with empty nickname rejected.

3. Reflection Utility Output

Display entity fields dynamically.

4. Sorted Lists Using Lambdas

Players sorted by score or age in team view.

H. Reflection

1. What I Learned

Strong understanding of SOLID in practice.

Proper use of abstract classes, inheritance, and interfaces.

How to design clean, maintainable OOP systems.

2. Challenges

Handling foreign key constraints and cascading deletes.

Correct generic repository design with JDBC.

Avoiding StackOverflow during recursive updates.

3. Value of SOLID Architecture

Code is modular and testable.

Adding new entities or features requires minimal changes.

Clear separation of concerns prevents bugs and improves readability.