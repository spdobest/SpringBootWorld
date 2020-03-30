# Spring Boot - DTOs - Data Transfer Objects
- DTOs Stands for Data Transfer Objects
- Exposing entity objects through REST endpoints can mount security issues provided if we dont
take enough care about which entity fields should be made available for publicly exposed REST
API.
- ModelMapper is a library which supports to convert entity objects to DTOs and DTOs to entity Object
- Intelligent
    - No manual mapping needed
    - Automatically projects and flattens complex models.
- Refactoring Safe
    - It provides a simple fluent API for handling special use cases
    - The API is type safe and refactoring safe
- Convention Based 
    - ModelMapper provides predefined conventions and if user is in need can create
    custom conventions.
- Extensible
    - ModelMapper supports integrations with any type of data model. In short ModelMapper
    does the heavy lifting for us.
- Reference
    - http://modelmapper.ord/
    - http://modelmapper.org/getting-started
  
## Model Mapper Implementation Steps
- Step-01: Create new GIT branch using IDE
- Step-02: Add Model Mapper dependency in pom.xml      
- Step-03: Define Model Mapper bean in APpConfig       
- Step-04: DTO Layer: Create DTO with name as UserMmDTO.      
- Step-05: Controller Layer : Create getUserDtoById method with Entity
to DTO conversion logic with Model Mapper in a new controller UserModelMapperController     
- Step-06: Commit and Push Code  

## STEPS in more details way
- Step 00: Introduction
- Step 01: New Git Branch
    - git Branch Name:Udemy-Springboot10-01-DTOS-ModelMapper
    - create new branch and upstream to git
- Step 02: Implement DTOS for user Entity using ModelMapper
    - Update pom.xml
    ```
        <!-- https://mvnrepository.com/artifact/org.modelmapper/modelmapper -->
        <dependency>
            <groupId>org.modelmapper</groupId>
            <artifactId>modelmapper</artifactId>
            <version>2.3.6</version>
        </dependency>
   ```   
- Step 03: Define ModelMapper Bean
    - Config layer
        - Create a config package
        - Create AppConfig class  
        - Define ModelMapper bean in configuration class
- Step 04: Create DTO class with name as UserMmDto
    - DTO layer
        - Create UserMmDto with fields userid, username
- Step 05: Create getUserDtoById method with Entity to DTO conversion Login
    - Controller Layer
        - Create new controller UserModelMapperController
        - Annotate with @RestController
        - Annotate with @RequestMapping("/modelmapper/users")
        - Create getUserDtoById method
            - GET /{id}
        - Implement ModelMapper conversion Logic
    - Test using POSTMAN
- Step 06: Commit Code 
    - Commit Code
    - Push branch to remote repo
    
         
                        
        
        
        
        
  
        
    
                            