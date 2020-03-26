# VALIDATION AND GLOBAL EXCEPTION HANDLING  
- **VALIDATION** User input is a very common & key requirement in today's world,
    Spring Boot provides strong support out of the box.  
- Spring Boot supports seamless integration with custom validators but the
    de-facto for performing validation is Hibernate Validator  
    (http://hibernate.org/validator).  
- **JSR 380:** JSR 380 is a specification of the java API for bean validation, which  
ensures that properties of a bean meet specific criteria, using annotations  
such as **@NotNull**, **@Min**, **@Max**  
- **@Valid Annotation** : when Spring Bootfinds an argument annotated
with **@Valid**, it automatically bootstraps the default JSR 380
implementation (Hibernate Validator) and validates the argument. when
the target argument fails to pass the validation, Spring Boot throws
a **MethodArgumentNotValidException** exception.
  
## Commonly Used - Validation Annotations  
- @NotNull : Validates that the annotated property value is not null  
- @Size : Validates that the annotated property value as a size between the
attributes min and max
- @Min : Validates that the annotated property has a value no smaller than
the value attribute.
- @Max : Validates that the annotated property has a value no larger than
the value attribute.
- @Email : Validates that the annotated property is a valid email address.
- @NotBlank : Validates that the property is not null or whitespace 
- @NotEmpty : Validates that the property is not null or Empty
- @AssertTrue : Validates that the annotated property value is true.
  
## Global Exception Handling  
- @ControllerAdvice  
    - Allows us to write global code that can be applied to a wide range of controllers.
    - By Default @ControllerAdvice annotation will be applicable to all classes that use
    @Controller which also applies for @RestController  
- @ExceptionHandler  
    - Annotation for handling exceptions in specific handler classes and/or handler
    methods
    - If used with controllers directly, we have the need to define it per controller but
    when used in combination with @ControllerAdvice it will only be used in Global
    Exception Handler class but applicable to all controllers due to @ControllerAdvice.
- @RestControllerAdvice
    - @RestControllerAdvice is Combination of both @ControllerAdvice and @ResponseBody
    - We can use the @ControllerAdvice annotation for handling exceptions in 
    the RESTful services but we need to add @ResponseBody separately.
      
## Use case Combination
- @ControllerAdvice & ResponseEntityExceptionHandler class
    - MethodArgumentNotValidException
    - HttpRequestMethodNotSupportedException
- @ControllerAdvice & @ExceptionHandler
    - For pre-defined exceptions like ConstraintViolationException
    - For Custom exceptions like UserNameNotFoundException
- RestControllerAdvice & @ExceptionHandler
    - For Custom exceptions like UserNameNotFoundException
    - For pre-defineed exceptions like "Exception.class" ( Applicable to all exceptions)            

## Implementation Steps
- Step 00 : Create git branch for validation and global exception handler
- Step 01 : Implement Bean Validation
- Step 02 : Implement Custom Global Exception Handler using @ControllerAdvice
& ResponseEntityExceptionHandler 
- Step 03 : Implement exception handler for 
HttpRequestMethodNotSupportedException 
- Step 04 : Implement exception handler for custom exception like
UserNameNotFoundException
- Step 05 : Path Variables validation & implement exception handler for
ConstraintViolationException  
   
   
## Step - 01 - Implement Bean Validation  
- Entity Layer  
    - Implement Validation on User Entity
        - @NotEmpty(message = "UserName is Mandatory field. Please Provide username")
        - @Size(min=2,message = "FirstName should have at least 2 characters")
    - Test Using POSTMAN
        - Service: Create UserService
        - Request body
            - For firstName, give only 1 character ("firstname":"k")
            - send username as empty ("username":"")
        - Verify Response on POSTMAN (JPA exception will be thrown)
    - Controller Layer
        - Enable Bean validation using @Valid
    - Test using POSTMAN
        - Service: Create User Service
        - Request Body
            - For firstname,give only 1 character  ("firstname":"k")  
            - send username as empty ("username":"")  
        - Verify Response
            - HTTP status 404 Bad Request - No Response Body
            - MethodArgumentNotValidException resolved from logs
              
## Step - 02 - Implement Custom Global Exception Handler - MethodArgumentNotValidException  
- Exception Layer - CustomerErrorDetails Class
    -  Create a new class CustomerErrorDetails
        - Define variables date,message, errorDetails
    - Add Fields Constructor
    - Add getters
- Exception Layer - CustomerGlobalExceptionHandler
    - Create a new class CustomerGlobalExceptionHandler
    - Extends ResponseEntityExceptionHandler   
    - @ControllerAdvice
        - Global Code that can be applied to a wide range of controllers.
    - Implement & Override handleMethodArgumentNotValid from ResponseEntityExceptionHandler class
- Test Using POSTMAN
        - Service: Create UserService
        - Request body
            - For firstName, give only 1 character ("firstname":"k")
            - send username as empty ("username":"")
        - Verify Response on POSTMAN (JPA exception will be thrown)
    
## Step - 03 - Implement "HttpRequestMethodNotSupportedException" in Custom Global Exception Handler  
- Test Using POSTMAN
    - Provide PATCH method for create user
    - verify response code and body
- Exception Layer - CustomerGlobalExceptionHandler 
    - Implement & Override handleHttpRequestMethodNotSupported from ResponseEntityExceptionHandler class
- Test Using POSTMAN
        - Provide PATCH method for create user
         - verify response code and body

## Step - 04 - Implement ExceptionHandler for custom exception like "UserNameNotFoundException"
- Exception Layer
    - Create a new class "UserNameNotFoundException"
        - extends Exception
        - Generate constructor from Super class
- Controller Layer
    - Throw UserNotFoundException if that user does not exists in Repository.           
- Test Using POSTMAN
    - Method: GET
    - URI: http://localhost:8080/users/byusername/abcd
    - verify default spring Exception ( Response code HTTP 500 )
- Exception Layer - CustomGlobalExceptionHandler
    - Create handleUserNameNotFoundException class
    - Annotate it with @ExceptionHandler
- Test Using POSTMAN    
    - Method: GET
    - URI: http://localhost:8080/users/byusername/abcd
    - verify the Response Body and HTTP Status Code  
 
 ## Step - 05 - Path Variables Validation & Handling ConstraintViolationException using CustomGlobalException
 - Controller Layer
      - getUserById method: add @Min(1) for Path Variable
      - Add @Validated annotation to UserController Class 
 - Test Using POSTMAN
     - Method: GET
     - URI: http://localhost:8080/users/0
     - verify default spring Exception ( Response code HTTP 500 )
 - Exception Layer - CustomGlobalExceptionHandler
     - Create HandleConstraintViolationException class
     - Annotate it with @ExceptionHandler
 - Test Using POSTMAN    
     - Method: GET
     - URI: http://localhost:8080/users/0
     - verify the Response Body and HTTP Status Code  
  
 ## Step - 06 - Implement Global Exception using RestControllerAdvice
- Exception Layer - CustomGlobalExceptionHandler
      - Comment @ControllerAdvice
      - Test to ensure controller advice is not in action for get`userByUserName
- Exception Layer - CustomGlobalExceptionHandler
     - Create new class GlobalRestControllerAdviceExceptionHandler
     - Annotate it with @RestControllerAdvice
     - Handle UserNameNotFoundException
        - Create a method notFound
        - Annotate it with @ExceptionHandler
        - Annotate it with @ResponseStatus - 404    
- Test Using POSTMAN    
     - Method: GET
     - URI: http://localhost:8080/users/byusername/abcsds
     - verify the Response Body and HTTP Status Code    
             