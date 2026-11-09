# HBMA

The Human-Based Microservices Architecture (HBMA) pattern: an architectural pattern for providing people’s information from their companion devices.

This repository provides a reusable implementation skeleton for the HBMA pattern. It includes an OpenAPI specification, a Java Spring Boot skeleton generated from that specification, and a simple running example that illustrates how a person’s virtual profile can be requested, shared, and made available as services.

---

## Repository contents

- `hbma-api.yaml`: OpenAPI 3.0 specification for the main HBMA entities.
- `hbma-java/`: Java Spring Boot skeleton generated from the OpenAPI specification.
- `examples/virtual-profile-example.json`: example of a person’s virtual profile.
- `examples/mqtt-running-example.md`: simplified MQTT-based running example aligned with the manuscript.
- `openapitools.json`: OpenAPI Generator configuration.

---

## HBMA running example

The running example follows the scenario described in the paper:

1. A controller detects a person in the environment.
2. The controller requests the person’s virtual profile.
3. The companion device provides the virtual profile.
4. The received profile is made available through services according to the associated access-control information.

This example is intentionally simple. Its goal is to show how the HBMA entities can be represented and exchanged, while the generated Java skeleton provides a reusable basis for more complete implementations.

---

## Features

- RESTful API for managing HBMA entities:
  - `Person`, with attributes such as `id`, `name`, `device`, and `virtualProfile`.
  - `Device`, with attributes such as `id`, `manufacturer`, and `model`.
  - `VirtualProfile`, containing a list of `Service` objects.
  - `Service`, with attributes such as `id`, `name`, `endpoint`, and `access`.
  - `AccessControl`, for managing privacy settings.
- Custom methods:
  - `sendProfile`: sends a person’s virtual profile.
  - `setPrivacy`: configures privacy settings for services.
- Code generation using OpenAPI Generator.
- Extensible design for adding new HBMA components, services, or persistence mechanisms.
- Example material for understanding the use of virtual profiles and MQTT-based profile exchange.

---

## Project structure

```text
HBMA/
├── README.md
├── hbma-api.yaml
├── openapitools.json
├── hbma-java/
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── ...
│       │   └── resources/
│       └── test/
└── examples/
    ├── virtual-profile-example.json
    └── mqtt-running-example.md
```

---

## OpenAPI specification

The API is defined using an OpenAPI 3.0 specification in `hbma-api.yaml`.

The main elements are:

- Paths:
  - `/persons`: retrieve or create persons.
  - `/persons/{id}`: retrieve a specific person by ID.
- Schemas:
  - `Person`
  - `Device`
  - `VirtualProfile`
  - `Service`
  - `AccessControl`

The OpenAPI specification can be used to generate server skeletons in Java, Python, Node.js, and other languages supported by OpenAPI Generator.

---

## Prerequisites

Before running the project, install:

- Java 11 or later
- Maven 3.6 or later
- OpenAPI Generator CLI
- Optional: an MQTT broker such as Mosquitto, if you want to reproduce the MQTT-based example conceptually

---

## Setup and execution

Clone the repository:

```bash
git clone https://github.com/dflores0806/HBMA.git
cd HBMA
```

Generate the Java Spring Boot skeleton from the OpenAPI specification:

```bash
openapi-generator-cli generate -i hbma-api.yaml -g spring -o hbma-java
```

Build and run the generated application:

```bash
cd hbma-java
mvn clean install
mvn spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

Example endpoints:

- `GET /persons`
- `POST /persons`
- `GET /persons/{id}`

If Swagger UI is enabled in the generated project, it can normally be accessed at:

```text
http://localhost:8080/swagger-ui.html
```

---

## Example virtual profile

The file `examples/virtual-profile-example.json` provides a simplified virtual profile for a person represented by a companion device.

The profile includes:

- person identifier;
- associated device;
- services exposed by the person;
- access-control information;
- preferences and objectives.

This example can be adapted to different domains where people’s information must be locally managed and selectively exposed as services.

---

## MQTT-based running example

The file `examples/mqtt-running-example.md` describes a simple MQTT-based interaction:

1. The controller publishes a profile request.
2. The companion device receives the request.
3. The companion device publishes the virtual profile.
4. The controller receives and processes the profile.
5. The profile information becomes available through HBMA services.

This example is aligned with the implementation discussion in the paper and illustrates how HBMA can be instantiated using message-based communication.

---

## Testing

To run the tests in the generated Java project:

```bash
cd hbma-java
mvn test
```

---

## Future enhancements

Possible future extensions include:

- persistence with a relational or document database;
- authentication and authorization mechanisms;
- richer access-control policies;
- validation of incoming requests;
- additional examples for edge, mobile, and IoT deployments;
- deployment instructions for cloud or container-based environments.

---

## Citation

If you use HBMA in your research, please cite the following publication:

**APA (7th edition)**

Flores-Martin, D., Berrocal, J., García-Alonso, J., Canal, C., & Murillo, J. M. (2026). HBMA: An architectural pattern for providing people's information from their companion devices. *Software: Practice and Experience*. https://doi.org/10.1002/spe.70120

**BibTeX (LaTeX)**

```bibtex
@article{FloresMartin2026HBMA,
  author  = {Flores-Martin, Daniel and Berrocal, Javier and García-Alonso, José and Canal, Carlos and Murillo, Juan M.},
  title   = {{HBMA}: An Architectural Pattern for Providing People's Information from their Companion Devices},
  journal = {Software: Practice and Experience},
  year    = {2026},
  doi     = {10.1002/spe.70120},
  url     = {https://doi.org/10.1002/spe.70120}
}
```

---

## Authors

 - Daniel Flores-Martin: [dfloresm@unex.es](mailto:dfloresm@unex.es)
   - COMPUTAEX. Extremadura Supercomputing Center (Spain)  
   - Lead Developer & Researcher

We welcome suggestions, issues and contributions from the community!