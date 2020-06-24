# Strings statistics

Provides strings statistics - number of strings occurences count and average length

## Getting Started

Project uses java 1.8 and spring boot. 
Application starts on port 8090 by default (configurable via application.properties)
It has a number of rest api endpoints to interact with application.

### Prerequisites

To run the application you need servlet container and jdk 1.8 installed.
Or just run StringstatisticsApplication in your IDE.

### How to use

Swagger UI is included as dependency so after starting the application
simply open http://localhost:8090/swagger-ui.html 
and look through String statistics API methods with their description.
You can send requests to the application via swagger-ui as well.
Alternatively using curl to load strings into application:
    
    curl -X POST \
      http://localhost:8090/api/load-strings \
      -H 'Content-Type: application/json' \
      -d '[
        "test string 1",
        "test string 2"
    ]'
 
to get statistics:

    curl -X GET \
      http://localhost:8090/api/get-statistics

to clear map:

    curl -X GET \
      http://localhost:8090/api/clear
      
## Running the tests

JUnit5 is used for tests. 
Tests are parameterized, so number of tests is greater 
than number of annotated methods.
To run tests use maven:

    mvn clean test
        
     
