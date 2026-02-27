# Book Collection API Tests

Automated API tests for book collection management system. Project covers authentication, user collection operations, and negative scenarios for global catalog access.

## Tech Stack

- **Java**
- **Maven**
- **Cucumber (BDD)**
- **REST Assured**
- **JUnit**

## Project Structure
```
src
├── main
│   └── java
└── test
├── java
│   ├── api              # API communication layer
│   ├── services         # Business logic wrappers
│   ├── data             # Test data
│   ├── runners          # Cucumber runner
│   └── stepdefinitions  # Step definitions
└── resources
└── features         # Cucumber feature files
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