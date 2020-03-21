# RESTFUL API USING JPA AND H2 DATABASE
   
## Steps we will cover  
**Step-1 -** use case Introduction  
**Step-2 -** Verify pom.xml for all Dependencies     
**Step-3 -**  Update application.properties required for JPA based RESTFUL services     
**Step-4-01 -**  Create User Entity - Understand @Entity Annotation    
**Step-4-02-**  Create User Entity - Understand @Table Annotation    
**Step-4-03-**  Create User Entity - Define Variables, Getters and Setters    
**Step-5-**  Understand and Implement Changes related to H2 Database    
**Step-6 -** Create User Repository - @Repository     
**Step-7 -** Implement getAllUsers Restful Services - @Service,@RestController 
**Step-8 -** Test getAllUsers RESTful Service- Using REST client POSTMAN      
**Step-9 -** Implement createUserRESTful Service - @PostMapping     
**Step-10 -** Implement getUserById RESTful Service - @GetMapping     
**Step-11 -** Implement updateUserById RESTful Service - @PutMapping     
**Step-12 -** Implement deleteUserById RESTful Service - @DeleteMapping
**Step-13 -** Implement getUserByUserName RESTful Service - @GetMapping
**Step-14 -** GIT Commit,Push, Merge to master and push
  
## STEP 1 - USECASE INTRODUCTION - USER MANAGEMENT SERVICE  
- Create User       - POST - /users
- Get all Users     - GET - /users
- Get User By Id    - GET - /users/{id}
- Update User       - PUT - /users/{id}
- Delete User       - DELETE - /users/{id}
- Get User By User Name  - GET - /users/byusername/{username}
  
## STEP 2 - Verify pom.xml for all Dependencies    
- Mandatory  
    - Spring Boot Starter Web  
    ```
    <dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    ```    
    - Spring Boot JPA  
    ```
    <dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
   ```  
   - Spring Boot Dev Tools
   ```
        <dependency>
      		<groupId>org.springframework.boot</groupId>
      		<artifactId>spring-boot-devtools</artifactId>
      		<scope>runtime</scope>
      		<optional>true</optional>
      	</dependency>
    ```    
    - H2 Database   
      ```
      <dependency>
          	<groupId>com.h2database</groupId>
          	<artifactId>h2</artifactId>
          	<scope>runtime</scope>
       </dependency>
        ```   
 ## STEP 3 - Update application.properties file                       
```
    server.port = 8080
    spring.jpa.show-sql=true
    spring.h2.console.enable=true
```  
  
 ## STEP 4 - Entity Creation (User Entity)
    - @Entity - 
    - @Table
    - Fields or variables( id, username,firstName,lastname,email,role,ssn )  
    - @Id
    - @GeneratedValue
    - @Column (name, length, nullable, unique)
    - No ARgs Constructor
    - Fields COnstructor
    - toString() - override this method
     