# Book Collection API Tests

The project focuses on automated API tests for a Book Collection Management System. It covers authentication mechanisms, user collection operations (such as adding and removing books), and negative test scenarios related to unauthorized access to the global catalog.

The system under test is based on the DemoQA Book Store application: [DemoQA Book Store](https://demoqa.com/books)

API documentation and available endpoints can be accessed via Swagger: [Swagger API Documentation](https://bookstore.toolsqa.com/swagger/)

The tests were designed based on the official API specification provided in the Swagger documentation.

## Tech Stack

- **Java**
- **Maven**
- **Cucumber (BDD)**
- **REST Assured**
- **JUnit**

## Project Structure
```
src/
├── main/
│   ├── java/
│   └── resources/
└── test/
    ├── java/
    │   └── com.example/
    │       ├── api/ 
    │       │   ├── AuthService.java
    │       │   ├── BaseApi.java
    │       │   └── CommonRequest.java
    │       ├── data/
    │       │   └── UserCredentials.java
    │       ├── services/
    │       │   └── AuthService.java
    │       ├── runners/
    │       │   └── TestRunner.java
    │       └── stepdefinitions/
    │           ├── LoginSteps.java
    │           ├── AddBookSteps.java
    │           ├── RemoveBookSteps.java
    │           └── AddBookToCatalogSteps.java
    └── resources/
        └── features/
            ├── login.feature
            ├── add_book.feature
            ├── remove_book.feature
            └── add_book_to_catalog.feature
```
## Covered Scenarios

**Authentication**
- Successful login
- Token validation

**User Collection**
- Add book to user collection
- Remove book from user collection

**Negative Case**
- Attempt to add book to global catalog (request rejected)

## How to Run Tests

Run all tests:
```bash
mvn test
```

Run specific runner:
```bash
mvn test -Dtest=TestRunner
```
