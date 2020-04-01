# Spring Boot - Actuator and Spring Bot Admin
- Step-01: New GIT branch usiong IDE
- Step-02: Add Spring Boot Actuator Dependency in pom.xml and
verify actuator endpoints
- Step-03: Expose all endpoints and verify health endpoint
and discuss about all other endpoints.
- Step-04: Info Endpoint: Populate build-info on info endpoint.
- Step 05: Metrics End Point
  
## Details Implementation Step by Step.
- Step-00: Introduction
- Step-01: New GIT branch
    - git branch name: Udemy-Springboot13-Actuator&Admin
    - Create new local branch   
- Step-02: Add Spring Boot Actuator Dependency to pom.xml and restart Embedded Tomcat
    ```
  <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator -->
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
      <version>2.2.6.RELEASE</version>
  </dependency>
    ```
    - Verify the Endpoint
        - http://localhost:8080/actuator
    - Only 2 endpoints
        - health
        - info
    - Other Endpoints (full details)
        - https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html 
- Step-03: Expose all Actuator endpoints.
    - application.properties
         - management.endpoints.web.exposure.include=*
    - Restart Embedded Tomcat
    - Verify the endpoints
         - http://localhost:8080/actuator
- Step-04: Info Endpoint
    - Retrieve Build properties
        - Update pom.xml
        ```
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <executions>
            <execution>
                <id>build-info</id>
                <goals>
                    <goal>build-info</goal>
                 </goals>
            </execution>
        </executionS>    
      </plugin>
      
        ```  
    - Actuator Automatically Environment properties which starts with info in application.properties
        - info.greetings=Good Morning
    - Info Endpoint can gather properties from many springboot externalized sources.
        - https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.xml
- Step-05: Metrics End Point                     
    - Metrics
        - http://localhost:8080/actuator/matrics                     
        - http://localhost:8080/actuator/matrics/jvm.memory.used                     
        - http://localhost:8080/actuator/matrics/jvm.threads.states                     
        - http://localhost:8080/actuator/matrics/http.server.request                     
        