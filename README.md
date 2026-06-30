# Simple Books API Automation Framework

### Overview

This project is a REST Assured + TestNG automation framework developed for testing the Simple Books API.

#### Base URL:

https://simple-books-api.click

#### The framework supports:

- GET API validation
- POST API validation
- PATCH API validation
- DELETE API validation
- Authentication token generation
- Optional query parameter validation
- Request and Response logging
- Dynamic test data generation
- Reusable service layer architecture

---

#### Technology Stack

- Java
- REST Assured
- TestNG
- Maven
- Jackson Databind

---

#### Framework Structure

##### SimpleBooksAPIFramework
##### │
##### ├── pom.xml
##### ├── testng.xml
##### │
##### ├── src/main/java
##### │
##### │ ├── base
##### │ │ └── BaseTest.java
##### │ │
##### │ ├── config
##### │ │ └── ConfigReader.java
##### │ │
##### │ ├── constants
##### │ │ └── EndPoints.java
##### │ │
##### │ ├── payloads
##### │ │ ├── ClientRequest.java
##### │ │ ├── OrderRequest.java
##### │ │ └── UpdateOrderRequest.java
##### │ │
##### │ ├── services
##### │ │ ├── AuthService.java
##### │ │ ├── BookService.java
##### │ │ └── OrderService.java
##### │ │
##### │ └── utils
##### │ ├── TokenManager.java
##### │ └── LogUtil.java
##### │
##### ├── src/main/resources
##### │ └── config.properties
##### │
##### ├── src/test/java
##### │ └── tests
##### │ ├── StatusTest.java
##### │ ├── BooksTest.java
##### │ ├── OrderTest.java
##### │ └── NegativeTest.java
##### │
##### └── logs

---

#### Features Implemented

1. Authentication

#### Endpoint:

- POST /api-clients

#### Features:

- Dynamic email generation using System.currentTimeMillis()
- Avoids 409 Client Already Registered errors
- Token stored and reused using TokenManager

---

2. Status API Validation

##### Endpoint:

  - GET /status

##### Validation:

- Status Code = 200
- Status = OK

---

3. Books API Validation

##### Endpoint:

- GET /books

##### Validation:

- Status Code = 200
- Books list returned successfully

---

4. Optional Query Parameter Validation

##### Endpoint:

- GET /books

##### Optional Parameters:

- type
- limit

##### Example:

- GET /books?type=fiction&limit=2

##### Validation:

- Response status code
- Response size
- Filtered data verification

---

5. Create Order

##### Endpoint:

- POST /orders

##### Validation:

- Status Code = 201
- created = true
- orderId generated successfully

---

6. Get Order

##### Endpoint:

- GET /orders/{orderId}

##### Validation:

- Status Code = 200
- Order details returned successfully

---

7. Update Order

##### Endpoint:

- PATCH /orders/{orderId}

##### Validation:

- Status Code = 204

##### Request Payload:

{
  "customerName": "Automation Tester"
}

---

8. Verify Updated Order

##### Endpoint:

- GET /orders/{orderId}

##### Validation:

- Updated customer name verified successfully

---

9. Delete Order

##### Endpoint:

- DELETE /orders/{orderId}

##### Validation:

- Status Code = 204

---

10. Negative Testing

##### Implemented Scenarios:

- Invalid Token → 401
- Missing Authorization
- Invalid Book Id
- Duplicate Client Registration → 409

---

##### Logging Implementation

- Console Logging

- Request and response logs are printed automatically.

##### Example:

- Request Method: POST
- Request URI: /orders

##### Request Body:
{
  "bookId":1,
  "customerName":"Rajkumar"
}

##### Response:
{
  "created":true,
  "orderId":"abc123"
}

##### File Logging

- Logs are stored under:

logs/

Each execution creates a separate log file.

##### Example:

logs/
├── API_Log_2026-06-30T10-30-25.log
├── API_Log_2026-06-30T11-05-15.log

##### Benefits:

- Easy debugging
- Historical execution tracking
- Jenkins artifact support

---

##### Configuration

##### File:

- src/main/resources/config.properties

##### Example:

- base.url=https://simple-books-api.click

---

##### Test Execution

- Run Using Maven

- mvn clean test

- Run Using TestNG

##### Execute:

- testng.xml

---

##### Design Pattern Used

- Service Layer Pattern

##### Responsibilities:

- Test Classes → Validation only
- Service Classes → API actions
- Payload Classes → Request body models
- Utilities → Common reusable functions

##### Benefits:

- Reusability
- Maintainability
- Scalability
- Cleaner test code

---

##### Future Enhancements

- Extent Reports
- Log4j2 Integration
- Request Specification Builder
- Response Specification Builder
- Retry Analyzer
- Jenkins Pipeline Integration
- Environment Management (QA/UAT/PROD)
- Allure Reporting

---

# Author

### Rajkumar J

### Automation QA Engineer

### Automation Testing | Selenium | Cucumber | TestNG | API Automation | Mobile Automation
