# Health Checker API using Spring Boot

This repository contains a Spring Boot-based Health Checker API that monitors the health of web services, endpoints, and related components. The purpose of this API is to detect any issues with the services early and help developers resolve them quickly, ensuring that applications remain healthy and efficient.

## Setup and Running the Project

### Prerequisites

Before you begin, ensure that you have the following installed:

- **Java 8 or higher** (You can check this by running `java -version`)
- **Maven 3.x** (Alternatively, you can use Gradle)
- **Git** (for cloning the repository)

### Cloning the Repository

Clone this repository to your local machine using the following command:


git clone https://github.com/yourusername/health-checker.git
Navigating to the Project Directory
Once the repository is cloned, change to the project directory:


cd health-checker
Building the Project
To build the project, run the following Maven command:


mvn clean install
This will download the necessary dependencies and compile the project.

Running the Application
To run the Spring Boot application, use the following command:

mvn spring-boot:run
The application will start on port 8080 by default. You can access it via:


http://localhost:8080
Accessing the Health Check Endpoint
The health check API is exposed at the following endpoint:


GET http://localhost:8080/health
When you send a GET request to this endpoint, the API will return the health status of your services.

Example of a Healthy Response:

{
  "status": "UP",
  "details": {
    "service1": "UP",
    "service2": "UP"
  }
}
Example of an Unhealthy Response:

{
  "status": "DOWN",
  "details": {
    "service1": "DOWN",
    "service2": "UP"
  }
}
Testing the Endpoint
To verify that the health check is working correctly, you can manually test it by visiting the following URL in your browser or using curl:

curl http://localhost:8080/health
