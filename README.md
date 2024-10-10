# Book Review API

A RESTful API for managing book reviews, allowing users to create, read, update, and delete books and their associated reviews.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Features

- Create, read, update, and delete books
- Add, update, and delete reviews for specific books
- H2 in-memory database for quick setup and testing
- Swagger documentation for easy API exploration

## Technologies Used

- **Java** - Programming language
- **Spring Boot** - Framework for building the API
- **Spring Data JPA** - Simplifies database access
- **H2 Database** - In-memory database for development and testing
- **Lombok** - Reduces boilerplate code
- **Swagger** - API documentation and testing interface

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/book-review-api.git
    ```
2. Navigate to the project directory:
    ```bash
    cd book-review-api
    ```
3. Build the project using Maven:
    ```bash
    mvn clean install
    ```
4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Usage

1. Once the application is running, you can access the API documentation at: http://localhost:8080/api-docs

2. You can also explore the API using Swagger UI at: http://localhost:8080/swagger-ui.html


## API Endpoints

### Books

- **Get all books**
- `GET /api/v1/books`
- **Get book by ID**
- `GET /api/v1/books/{bookId}`
- **Create a new book**
- `POST /api/v1/books`
- **Update a book**
- `PUT /api/v1/books/{bookId}`
- **Delete a book**
- `DELETE /api/v1/books/{bookId}`

### Reviews

- **Get all reviews for a book**
- `GET /api/v1/books/{bookId}/reviews`
- **Add a review to a book**
- `POST /api/v1/books/{bookId}/reviews`
- **Update a review**
- `PUT /api/v1/books/{bookId}/reviews/{reviewId}`
- **Delete a review**
- `DELETE /api/v1/books/{bookId}/reviews/{reviewId}`

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a Pull Request.
