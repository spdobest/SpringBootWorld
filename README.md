# Spring Boot - MapStruct
- MapStruct is a code generator that simplifies bean mappings
- Mapping classes are generated during compilation and no runtime processing or
reflection is used.
- Mapping classes use simple method invocation, which makes them really easy to 
debug.
- we generally notice a lot of boilerplate code converting POJOs to other POJOs.
- Very common type of conversion we see regularly is in between persistence-backed entities and DTOs that go out the client side
- The problem that MapStruct solves is it can generate bean mapper classes
automatically. If we go by implementing them manually, creating bean mappers is time consuming
- MapStruct also requires a processor plugin to be added
to pom.xml. The mapstruct-processor is used to generate the mapper 
implementation during build phase.
  
## MapStruct Implementation Steps
- Step-01: Create new GIT branch using IDE
- Step-02: Update pom.xml with necessary dependencies for MapStruct
- Step-03: Create UserMsDTO class required for MapStruct Implementation
- Step-04: Create the MapStruct Mapper Interface
- Step-05: Create the REST services by calling methods defined in
MapStruct Mapper
- Step-06: Commit and push the Code to remote repository
  
## DETAIL STEPS TO IMPLEMENT MAPSTRUCT
- Step-01: NEW GIT BRANCH
    - git branch name: Udemy-Springboot10-02-DTOS-MapStruct
    - Create new local branch  
- Step-02: Update pom.xml with necessary dependencies forMapStruct
    - Change#1
         ```
        <properties>
            <org.mapstruct.version>1.3.0.Final</org.mapstruct.version>
            <org.apache.maven.plugins.version>3.8.0</org.apache.maven.plugins.version>
      </properties>
       ```  
    - Change#2: Add MapStruct Dependency      
       ```
       <!-- https://mvnrepository.com/artifact/org.mapstruct/mapstruct -->
       <dependency>
           <groupId>org.mapstruct</groupId>
           <artifactId>mapstruct-jdk8</artifactId>
           <version>${org.mapstruct.version}</version>
       </dependency>
        ```      
    - Change3: Add MapStruct Processor Plugin
        ```
    <plugin>
    		<groupId>org.apache.maven.plugins</groupId>
    		<artifactId>maven-compiler-plugin</artifactId>
    		<version>${org.apache.maven.plugins.version}</version>
    		<configuration>
    			<source>${java.version}</source>
    			<target>${java.version}</target>
    			<annotationProcessorPaths>
    				<path>
    					<groupId>org.mapstruct</groupId>
    					<artifactId>mapstruct-processor</artifactId>
    					<version>${org.mapstruct.version}</version>
    				</path>
    			</annotationProcessorPaths>
    		</configuration>
    	</plugin>
     ``` 
- Step-03:  Create UserMsDTO class required for MapStruct Implementation.
    - DTO Layer
        - Create UserMsDto in dtos package
        - Define fields that need to be exposed via UserMsDto
        - Generate No Argument and Field Constructor
- Step-04: Create the MapStruct Mapper Interface
    - Create an interface with methods for mapping between objects (User to UserMsDto) 
    - Add @Mapper annotation to the interface
    - Add a 'commentModel' attribute with the value of 'spring' to the @Mapper annotation
    - Create Methods
        - userToUserDto
            - Input Object: User
            - Output Object: UserMsDto
            - @Mapping(source ="email",target="emailaddress")
        - userToUserDtos
             - Input Object: List<User>
             - Output Object: List<UserMsDto> 
- Step-05: Create the REST services by calling methods defined in MapStruct Mapper.
    - Controller Layer
        - Create new Controller named UserMapStructController
        - Copy getUserById and getAllUsers methods from UserController
        - Test
    - getUserByIdMsDtos
        - Implement this method to return DTO converted by MapStruct
        - Test  
- Step-06: Commit and Push Code to remote repository  
- Step-01:  
- Step-01:  

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
    
         
                        
        
        
        
        
  
        
    
                            