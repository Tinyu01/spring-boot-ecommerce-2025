# Spring Boot E-commerce Application

This project is a Spring Boot-based e-commerce application that consists of two main services: an authentication service and a product service. Each service is designed to be modular and independently deployable, allowing for scalability and maintainability.

## Project Structure

```
spring-boot-ecommerce-jpa
├── auth-service
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── example
│   │   │   │           └── auth
│   │   │   │               ├── AuthServiceApplication.java
│   │   │   │               ├── config
│   │   │   │               ├── controller
│   │   │   │               ├── model
│   │   │   │               ├── repository
│   │   │   │               └── service
│   │   │   └── resources
│   │   │       ├── application.properties
│   │   │       └── static
│   │   └── test
│   │       └── java
│   │           └── com
│   │               └── example
│   │                   └── auth
│   │                       └── AuthServiceApplicationTests.java
│   └── pom.xml
├── product-service
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── example
│   │   │   │           └── product
│   │   │   │               ├── ProductServiceApplication.java
│   │   │   │               ├── config
│   │   │   │               ├── controller
│   │   │   │               ├── model
│   │   │   │               ├── repository
│   │   │   │               └── service
│   │   │   └── resources
│   │   │       ├── application.properties
│   │   │       └── static
│   │   └── test
│   │       └── java
│   │           └── com
│   │               └── example
│   │                   └── product
│   │                       └── ProductServiceApplicationTests.java
│   └── pom.xml
├── .gitignore
├── README.md
└── pom.xml
```

## Services Overview

### Auth Service
- **Purpose**: Manages user authentication and registration.
- **Key Components**:
  - `AuthController`: Handles authentication requests.
  - `RegistrationController`: Manages user registration.
  - `UserService`: Provides user management functionalities.
  - Security and observability configurations.

### Product Service
- **Purpose**: Manages product listings and recommendations.
- **Key Components**:
  - `ProductController`: Handles product-related requests.
  - `GraphQLController`: Manages GraphQL queries and mutations.
  - `ProductService`: Provides product management functionalities.
  - AI-based recommendation service.

## Configuration
- Each service has its own `application.yml` file for configuration settings.
- Docker and Kubernetes configurations are included for deployment.

## Getting Started
1. Clone the repository.
2. Navigate to the `auth-service` or `product-service` directory.
3. Build the project using Maven: `mvn clean install`.
4. Run the application: `mvn spring-boot:run`.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.

## Contributing
Contributions are welcome! Please open an issue or submit a pull request for any improvements or features.