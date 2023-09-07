<div align="center">

  # GamerScore-Hub (Backend) 🎮
    
  [![License MIT](https://img.shields.io/github/license/Ivi-SCD/backend-gamerscore-hub?style=for-the-badge&logo=License")](https://github.com/Ivi-SCD/poo-java/blob/main/LICENSE)
  ![Stars](https://img.shields.io/github/stars/Ivi-SCD/backend-gamerscore-hub?style=for-the-badge&logo=License")
  ![Forks](https://img.shields.io/github/forks/Ivi-SCD/backend-gamerscore-hub?style=for-the-badge&logo=License")

</div>

**Welcome to GamerScoreHub (the web-based game ranking system) backend repository**. The purpose of this system is to enable users to keep track of newly released games and rate games.

### Project Steps 🚀

* *Requirement Collection and Analysis*
* *Development of the [Logical Model](https://github.com/Ivi-SCD/backend-gamerscore-hub/assets/81643916/68a6fc54-0e1f-433d-ba94-fedca3d5f221)*
* *Backend Development + [Physical Model](https://github.com/Ivi-SCD/backend-gamerscore-hub/assets/81643916/a071fd08-a7a0-4d02-9d74-b78ee33a1601)*
  * *API Development*
  * *Testing*
  * *CI/CD Pipeline*
  * *Deployment*
* *Front-End Development **(In progress)***

### Technologies Used 💻

The primary programming language for API development was **Java in its version 17 and OpenJDK 20**. The chosen package manager for better dependency management was **Maven** for its support and practicality.

* Java
* Maven

#### Frameworks and Libraries

* Spring Boot
* Spring Data JPA
* JWT
* Spring Security
* Springdoc OpenAPI
* Bean Validation
* JUnit
* Flyway
* Lombok

The framework used was Spring for its autoconfiguration of external dependencies and ease of coding, along with various compatible libraries for the project's purposes. **JPA was used as an ORM tool**, and **migration control with Flyway**. Additionally, **JWT implementation with Spring Security** was done to maintain API security and best practices, and **documentation with SpringDoc (Swagger)**. Integration tests were also implemented using the same root database to make integration testing more accurate.

#### Databases

* MySQL

The primary database used was **MySQL in its version 8.0** due to its support for small and medium-sized applications and scalability compatible with the project's objectives.

#### Development Tools

* Git
* Github Action
* Github
* Docker
* IntelliJ

The primary tool for code versioning was **Git**. Additionally, the entire development environment was used in the popular Jetbrains IntelliJ IDE. CI/CD pipelines were built with Github Action, and the application's Dockerization process was automated with the Docker.yml workflow.

**Deployment:**

* Railway

Furthermore, the application was deployed using the Railway tool.

### How to Run the Project 🍃

There are two ways to run the project, with the first (taught in this section) involving cloning the project and the second pulling the image directly from Dockerhub:

1. Clone the repository using the command:
   ```
   git clone https://github.com/Ivi-SCD/backend-gamerscore-hub.git
   ```
2. Start the database defined in the docker-compose.yml file:
   ```
   docker-compose up -d
   ```
3. Run the application in your favorite IDE.
