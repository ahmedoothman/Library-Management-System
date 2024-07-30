markdown

# Library Management System

## Swagger Documentation

- [Swagger UI - HTML Format](http://localhost:8080/swagger-ui.html)
- [OpenAPI JSON Description](http://localhost:8080/v3/api-docs)

## Project Description

This project is a Library Management System API built using Spring Boot. It allows librarians to manage books, patrons, and borrowing records.

## Requirements

### Entities

- **Book**: Includes attributes like ID, title, author, publication year, ISBN, etc.
- **Patron**: Contains details like ID, name, contact information, etc.
- **Borrowing Record**: Tracks the association between books and patrons, including borrowing and return dates.

### API Endpoints

#### Book Management Endpoints

- **GET** `/api/books`: Retrieve a list of all books.
- **GET** `/api/books/{id}`: Retrieve details of a specific book by ID.
- **POST** `/api/books`: Add a new book to the library.
- **PUT** `/api/books/{id}`: Update an existing book's information.
- **DELETE** `/api/books/{id}`: Remove a book from the library.

#### Patron Management Endpoints

- **GET** `/api/patrons`: Retrieve a list of all patrons.
- **GET** `/api/patrons/{id}`: Retrieve details of a specific patron by ID.
- **POST** `/api/patrons`: Add a new patron to the system.
- **PUT** `/api/patrons/{id}`: Update an existing patron's information.
- **DELETE** `/api/patrons/{id}`: Remove a patron from the system.

#### Borrowing Endpoints

- **POST** `/api/borrow/{bookId}/patron/{patronId}`: Allow a patron to borrow a book.
- **PUT** `/api/return/{bookId}/patron/{patronId}`: Record the return of a borrowed book by a patron.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven or Gradle
- VS Code with Java extensions

### Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-username/your-repository.git
   cd your-repository
   Open the Project in VS Code
   ```

Launch VS Code and open the project directory.

Build the Project

If you're using Maven:

```bash
mvn clean install
```

If you're using Gradle:

```bash
./gradlew build
```

Run the Application

You can run the Spring Boot application from the command line:

```bash
mvn spring-boot:run
```

or

```bash
./gradlew bootRun
```

Access the Application

Open your web browser and navigate to http://localhost:8080/swagger-ui.html to view the Swagger UI and interact with the API.

Testing
Run the unit tests to validate the functionality of API endpoints:

```bash
mvn test
```

or

```bash
./gradlew test
```

Documentation
For detailed API documentation, refer to the Swagger UI and the OpenAPI JSON description linked above.
