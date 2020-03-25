# EXCEPTION HANDLING WITH ResponseStatusException  
- Spring5 Introduces the ResponseStatusException class which is a fast way for basic error handling in our RESTful API's
- Its is an alternative to @ResponseStatus and is the base class for exceptions used for applying status code to an HTTP Response  
- We can create an instance of it providing HttpStatus and optionally a reason and a cause  
- It's a RuntimeException.  
- ResponseStatusException constructor arguments  
    - status: an HTTP status set to HTTP Response
    - reason: a message explaining the exception set to that particular HTTPresponse  
    - cause: a Throwable cause of the ResponseStatusException  
      
        
 **Benefits of  ResponseStatusException class**  
    - We can implement it quite fast
    - THere is no specific need for creating custom exception classes, Unless we have
      a need because we can define HTTP response Status code and error Message at a time
    - As we are creating exceptions programmatically, we will have more control over
      Exception handling
**DownSide**  
    - **Code Duplication:** As we are defining them programmatically, we find ourselves replicating
        code in multiple controllers.
    - **Global Exception Handling**: This approach will not look like a global approach like
        @ControllerAdvice. Its difficult to enforce application-wide conventions.
**Combine Approaches**
    - We can implement @ControllerAdvice globally and ResponseStatusException
      Locally as and when Required.  
       
## STEPS TO IMPLEMENT   
 - Step0: Create a git branch for Exception Handling  
 - Step1: Implement "ResponseStatusException" for getUserById Service  
 - Step2: Implement "ResponseStatusException" for updateUserById Service  
 - Step3: Implement "ResponseStatusException" for deleteUserById Service directly at Service Layer 
 - Step4: Implement "ResponseStatusException" for createUser Service 
 - Step5: Implement HTTP Status code - 201 Created and Location Header with user path for CreateUser Service 
  
## STEP 1 : Implement "ResponseStatusException" for createUser Service   
   - Custom Exception Layer:
        - Create "UserExistException" which extends Exception
   - Service Layer:       
        -  Update the createUser method with throws Exception  
        - Check for user and if not exists throw exception  
   - Controller Layer
        - Update the createUser method with try and catch block
        - In Catch Block, implement "ResponseStatusException".
   - Test Using Postman.
        - Method: POST
        - URI: http://localhost:8080/users
   - Remove Trace in Exception
        - When Using DevTools,"server.error.include-stacktrace" will be set to always
        - Change to never or on-trace-param
   - Verify the response Again.
        - Exception Message
        - HTTP Status Code 
            
## STEP 2 : Implement "ResponseStatusException" for getUserById Service   
   - Custom Exception Layer:
        - Create "UserNotFoundException" which extends Exception
   - Service Layer:       
        -  Update the getUserById method with throws Exception  
        - Check for user and if not exists throw exception  
   - Controller Layer
        - Update the getUserById method with try and catch block
        - In Catch Block, implement "ResponseStatusException".
   - Test Using Postman.
        - Method: GET
        - URI: http://localhost:8080/users/101
   - Remove Trace in Exception
        - When Using DevTools,"server.error.include-stacktrace" will be set to always
        - Change to never or on-trace-param
   - Verify the response Again.
        - Exception Message
        - HTTP Status Code   
   
## STEP 3 :  Implement "ResponseStatusException" for updateUserById Service   
   - Service Layer:       
        -  Update the updateUserById method with throws Exception  
        - Check for user and if not exists throw exception  
   - Controller Layer
        - Update the updateUserById method with try and catch block
        - In Catch Block, implement "ResponseStatusException".
   - Test Using Postman.
        - Method: PUT
        - URI: http://localhost:8080/users/101
   - Remove Trace in Exception
        - When Using DevTools,"server.error.include-stacktrace" will be set to always
        - Change to never or on-trace-param
   - Verify the response Again.
        - Exception Message
        - HTTP Status Code     
        
## STEP 4 : Implement "ResponseStatusException" for deleteUserById Service   
   - Service Layer:       
        -  Update the deleteUserById method with throws Exception  
        - Check for user and if not exists throw exception  
   - Controller Layer
        - Update the deleteUserById method with try and catch block
        - In Catch Block, implement "ResponseStatusException".
   - Test Using Postman.
        - Method: DELETE
        - URI: http://localhost:8080/users/101
   - Remove Trace in Exception
        - When Using DevTools,"server.error.include-stacktrace" will be set to always
        - Change to never or on-trace-param
   - Verify the response Again.
        - Exception Message
        - HTTP Status Code  
        
## STEP 5 : Implement "ResponseStatusException" for createUser Service  
   - HTTP status code 201 & Location Header with User URI path
        - Controller Layer
            - Implement service to return HTTP status code 201
            - Implement Service to return Location Header as user path
   - Test Using Postman.
        - Method: POST
        - URI: http://localhost:8080/users/101
        - Request Body:
        - Verify the response
            - HTTP Status Code
            - Location Header in Response Headers 

            
                         
