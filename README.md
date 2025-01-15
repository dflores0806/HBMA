# HBMA
The Human-Based Microservices Architecture (HBMA) pattern: an Architectural Pattern for Providing People’s Information from their Companion Devices

---

## Features

- **RESTful API** for managing entities:
  - `Person` with attributes like `id`, `name`, `device`, and `virtualProfile`.
  - `Device` containing `id`, `manufacturer`, and `model`.
  - `VirtualProfile` containing a list of `Service` objects.
  - `Service` with attributes `id`, `name`, `endpoint`, and `access` (reference to `AccessControl`).
  - `AccessControl` for managing privacy settings with attributes `id`, `name`, and `value`.
- Custom methods:
  - `sendProfile`: Sends a person's virtual profile.
  - `setPrivacy`: Configures privacy settings for services.
- **Code generation** using OpenAPI Generator:
  - Automatically generates models, controllers, and services from the OpenAPI specification.
- **Extensible design**: Easy to customize and add new functionality.

---

## Project Structure

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── com.example.api/
│   │   │   ├── controllers/   # REST controllers for handling API requests
│   │   │   ├── models/        # Data models (Person, Device, VirtualProfile, etc.)
│   │   │   ├── services/      # Business logic interfaces and implementations
│   │   │   └── exceptions/    # Custom exceptions for error handling
│   ├── resources/
│   │   ├── application.yml    # Spring Boot application configuration
└── test/
    ├── java/                  # Unit and integration tests
```

## OpenAPI Specification

The API is defined using an OpenAPI 3.0 specification, detailed in the [`hbma-api.yaml`](hbma-api.yaml) file. The main components include:

- **Paths**:
  - `/persons`: Retrieve or create persons.
  - `/persons/{id}`: Retrieve a specific person by ID.
- **Schemas**:
  - `Person`, `Device`, `VirtualProfile`, `Service`, and `AccessControl`.

### Excerpt

```yaml
openapi: 3.0.0
info:
  title: API for Managing Persons and Devices
  version: 1.0.0
paths:
  /persons:
    get:
      summary: Retrieve a list of persons
      responses:
        '200':
          description: A list of persons
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Person'
    post:
      summary: Create a new person
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Person'
components:
  schemas:
    Person:
      type: object
      properties:
        id:
          type: string
        name:
          type: string
        device:
          $ref: '#/components/schemas/Device'
        virtualProfile:
          $ref: '#/components/schemas/VirtualProfile'
    Device:
      type: object
      properties:
        id:
          type: string
        manufacturer:
          type: string
        model:
          type: string
    VirtualProfile:
      type: object
      properties:
        service:
          type: array
          items:
            $ref: '#/components/schemas/Service'
    Service:
      type: object
      properties:
        id:
          type: string
        name:
          type: string
        endpoint:
          type: string
        access:
          $ref: '#/components/schemas/AccessControl'
    AccessControl:
      type: object
      properties:
        id:
          type: string
        name:
          type: string
        value:
          type: string
```

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java**: Version 11 or later.
- **Maven**: Version 3.6 or later.
- **OpenAPI Generator CLI**: Install it by following the [OpenAPI Generator installation instructions](https://openapi-generator.tech/docs/installation/).

---

## Setup and Execution

Follow these steps to set up and run the application locally:

1. **Clone the repository**:
   ```bash
   git https://github.com/dflores0806/HBMA.git
   cd HBMA
   ```    
2. **Generate the Code: If the code has not been generated yet, use the OpenAPI Generator CLI to generate the necessary files**:
   ```bash
	openapi-generator-cli generate -i hbma-api.yaml -g spring -o hbma
	```
	
3. **Build and Run: After generating the code, build the application with Maven and start the Spring Boot server**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   
4. **Access the API**:
   - **Base URL**: `http://localhost:8080`
   - Example Endpoints:
     - `GET /persons`: Retrieve all persons.
     - `POST /persons`: Create a new person.

5. **Swagger UI** (if enabled):
   Navigate to `http://localhost:8080/swagger-ui.html` to explore and test the API.
   
## Testing

To run the tests, use Maven:

```bash
mvn test
```

## Future Enhancements

We have some plans for future improvements in the application:

- **Database Integration**: Implement persistence with a relational database using JPA/Hibernate.
- **Security**: Introduce authentication and authorization mechanisms such as JWT or OAuth2.
- **Request Validation**: Enhance validation for incoming requests using annotations like `@Valid`.
- **Cloud Deployment**: Adapt the application for deployment to cloud platforms like AWS, GCP, or Azure.
