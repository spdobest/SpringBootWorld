# Spring Boot - Content Negotiation.
 - URI Versioning
 - Request Parameter Versioning
 - Custom Header Versioning
 - Media Type or Mime Type or Accept Header Versioning
 
## API Versioning - Detailed Implementation Steps
- Step 00: Introduction
- Step-01: New GIT branch
    - git Branch Name : Udemy-Springboot11-2-ContentNegotiation
    - Create new local branch
- Step-02: Test Using POSTMAN
    - getAllUsers (GET)
        - GET /users
        - Request Header
            - Accept: application/xml
    - Create User (POST)
        - POST /users
        - Request Header
            - Content-Type: application/xml
- Step-03: Add dependency in pom.xml & Restart embedded TomCat
```
            <dependency>
     			<groupId>com.fasterxml.jackson.dataformat</groupId>
     			<artifactId>jackson-dataformat-xml</artifactId>
     			<version>2.10.2</version>
     		</dependency>
```   
- Step-04: Test Using POSTMAN
    - getAllUsers (GET)
        - GET /users
        - Request Header
            - Accept: application/xml
    - Create User (POST)
        - POST /users
        - Request Header
            - Content-Type: application/xml 
- Step-05: Commit & Push Code to remote branch
                 