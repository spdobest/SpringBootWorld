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
       
 ## STEP 5 - H2 database
- In memory database ( data will be lost when we restart JVM or when JVM reloads)
- Populate DB during runtime
- Create data.sql in src/main/resources  
- NOTE: Columns will be created in Alphabetical order in DB except Primaty Key Id
- NOTE: SO insert statement values should be in alphabetical order as displayed in H2 database  
- H2 Console: http://localhost:8080/h2-console
- JDBC URL : jdbc:h2:mem:testdb  
      
**H2 DB Records**  
  insert into user values(101,'abcd@gmail.com','SIba','Mohanty','Admin','ssn101','sMohanty');  
  insert into user values(102,'def@gmail.com','Pooja','swain','Wiser','ssn102','pSwain');  
  insert into user values(103,'xyz@gmail.com','Babu','Lenka','asas','ssn103','bLenka');  
          
 ## STEP 6 - Create Repository
- Create a Interface
- extends JpaRepository
- @Repository
    
 ## STEP 7 - Implement getAllUsers Method  
- Service:
   - Create a UserService Class
   - Annotate it with @Service
   - @Autowired (Autwire UserRepository)
   - Create getAllUsers Method
- Controller   
   - Create a UserController Class
   - Annotate it with @RestController
   - @Autowired (Autowire UserService)
   - Create @GetMapping for getAllUsersMethod
          
 ## STEP 8 - Test Using REST Client - POSTMAN  
- Download & Install POSTMAN - https://www.postman.com/
- Create a Collection "Springboot - BuildingBlocks"
- Create a request for getAllUsers
   - Method: GET
   -URI: https://localhost:8080/users
- Test And Verify getAllUsers RESTful service    
  
## STEP 9 - Implement CreateUser Method in Service & Controller Layers  
- Service Layer:
    - Implement CreateUser Method  
- Controller Layer
    - Implement CreateUser Method
        - @RequestBody Annotation
    - Add @PostMapping Annotation to createUser Method    
- POSTMAN: Verify the createUser RESTful Service in postman REST
    - Create a request for CreateUser
        - Body (select Raw)
        - Content Type: JSON (application/json)
        - Method: POST
   - Test Using Postman  
    
## STEP 10 - Implement getUserById Method in Service & Controller Layers  
- Service Layer:
    - Implement CreateUser Method  
- Controller Layer
    - Implement getUserById Method
    - Discuss about return type Optional Object
- Controller Layer:  
    - Create getUserById method and apply optional return type
    - @PathVariable Annotation
    - Annotate @GetMapping for getUserById Method
    - URI: /users/{id}  
- POSTMAN: Create and Verify the getUserById RESTful Service in postman REST 
    - Method: GET
   - URL: http://localhost:8080/users/{id} 
   - URL: http://localhost:8080/users/{102}  
  
## STEP 11 - Implement updateUserById Method in Service & Controller Layers  
- Service Layer:
    - Create updateUserById Method
    - Inputs (User, id)  
- Controller Layer
    - Create updateUserById Method
    - @PathVariable
    - @RequestBody
    - Annotate @PutMaping for updateUserById Method
- POSTMAN: Verify the updateUserById RESTful Service in postman REST   
    - Create a Request for updateUserById
    - Body (select raw)
    - Content Type: JSON ( application/json )
    - Method: POST
    - URL: http://localhost:8080/users/{id} 
    - URL: http://localhost:8080/users/{102}   
    - Test Using PostMan  
## STEP 12 - Implement deleteUserById Method in Service & Controller Layers  
- Service Layer:
    - Create deleteUserById Method
    - Verify user exists and then delete it  
- Controller Layer
    - Create deleteUserById Method
    - @PathVariable Annotation 
    - Annotate @DeleteMaping for deleteUserById Method
- POSTMAN: Verify the deleteUserById RESTful Service in postman REST   
    - Create a Request for deleteUserById 
    - Content Type: JSON ( application/json )
    - Method: DELETE
    - URL: http://localhost:8080/users/{id} 
    - URL: http://localhost:8080/users/{102}   
    - Test Using PostMan    
  
## STEP 13 - Implement getUserByUserName Method in Repository,Service & Controller Layers  
- Repository Layer:
    - Define "findByUserName" in UserRepository Interface
- Service Layer:
    - Create getUserByUserName Method
    - Input as userName (String)  
- Controller Layer
    - Create getUserByUserName Method
    - @PathVariable Annotation 
    - Annotate @GetMapping for getUserByUserName Method
    - URI: /users/byusername/{username}
- POSTMAN: Verify the getUserByUserName RESTful Service in postman REST   
    - Create a Request for getUserByUserName 
    - Content Type: JSON ( application/json )
    - Method: GET
    - URL: http://localhost:8080/users/{username} 
    - URL: http://localhost:8080/users/{spm}   
    - Test Using PostMan         
                        
                    