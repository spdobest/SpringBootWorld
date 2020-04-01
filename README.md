# Spring Boot - SWAGGER
- Documenting REST API is very important primarily from API consumers point of
view.
- API Documentation helps consumers to understand and implement their client
applications without any confusion and also by avoiding costly mistakes.
- One of the most popular API documentation specifications is OpenApi, formerly
known as Swagger.
- Swagger allows us to describe API properties either using JSON or YAML
metadata.
- Swagger also provides a Web UI which transforms the JSON metadata to a nice 
HTML Documentation.
- Swagger UI can also be used as a REST client.
- Swagger integration with Spring Framework can be implemented using SpringFox
dependencies.
  
## Swagger - Implementation Steps
- Step-01: New GIT breanch
- Step-02: Add Springfox dependencies to pom.xml
- Step-03: Create SwaggerConfig File
- Step-04: Adding API info to modify header part of our documentation
- Step-05: Restrict scope of sagger document generation using API basepackages & Paths 
- Step-06: Auto populate documentation for JSR-303 Validations
- Step-07: Adding Swagger Core Annotations to Model Classes
- Step-08: Adding Swagger Core Annotation to Controller classes
- Step-09: Commit & Push code.   
    
## Swagger - Implementation Details Steps
- Step-00: Introduction
- Step-01: New GIT branch
    - git branch name: Udemy-Springboot12-Swagger
    - Create new local branch   
- Step-02: Add Springfox dependencies to pom.xml and restart Embedded Tomcat
```
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
```
Also Add Swagger UI dependency
```
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.8.0</version>
		</dependency>
```

- Step-03: Create SwaggerConfig File
    - Annotate it with @Configuration
    - Annotate it with @EnableSwagger2
    - Create a Docket bean and annotate with @Bean
    - Swagger Metadata URL
        - http://localhost:8080/v2/api-docs
        - Verify in readable format in SWAGGER online editor https://editor.swagger.io/
        - Fix optional<User> responses.
    - Swagger UI URL
        - http://localhost:8080/swagger-ui.html
- Step-04: Adding API info to modify header part of our documentation
    - Create a new class "ApiInfo"
    - Update the Docket bean with this ApiInfo.
- Step-05: Restrict scope of sagger document generation using API basepackages & Paths
    - Update base package in RequestHandlerSelectors.basePackage
    - Update PathSelectors.ant("/users/**") to limit to specific paths. 
    - Verify in readable format in SWAGGER online editor https://editor.swagger.io
    - Fix Optional<User> responses.
    - Test Using REST client of SWAGGER
- Step-06: Auto populate documentation for JSR-303 Validations
    - JSR-303 Spec: https://beanvalidation.org/1.0/spec
    - Add Dependency in pom.xml and Restart Embedded tomcat
    ```
      <dependency>
          <groupId>io.springfox</groupId>
          <artifactId>springfox-bean-validators</artifactId>
          <version>2.9.0</version>
      </dependency>
    ```              
     - Add "@Import(BeanValidatorPluginsConfiguration.class)" on top of swagger configuration file
     - Verify Models in Swagger UI
- Step-07: Adding Swagger Core Annotations to Model Classes
    - Core Annotations documentation
        - https://github.com/swagger-api/swagger-core/wiki/Annotations
    - Core Annotations for Model Class
        - Class Level:
            - @ApiModel(description = "Mode to Create a new user")
        - Field Level: notes, required, position, unordered without position
            -  @ApiModelProperty(notes = "userid - Unique identifier of users", required = true)  
            -  @ApiModelProperty(notes = "username of user", required = false, position = 2)  
            -  @ApiModelProperty(notes = "first name of user", example = "Siba" required = false)  
            -  @ApiModelProperty(notes = "SSN of users", example="SSN", required = false)  
- Step-08: Adding Swagger Core Annotation to Controller classes
    - Controller Level
        - @Api(tags = "User Management RESTFul Services", value = "UserController",description="")
    - Method Level
        - @ApiOperation(value="create a new user")
    - Parameter Level
        - @ApiParam("User information for a new user to be created.")
    - produces        
- Step-09: Commit & Push code.     