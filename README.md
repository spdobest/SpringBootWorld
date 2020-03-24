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
       
# STEPS TO IMPLEMENT   
 - Step0: Create a git branch for Exception Handling  
 - Step1: Implement "ResponseStatusException" for getUserById Service  
 - Step2: Implement "ResponseStatusException" for updateUserById Service  
 - Step3: Implement "ResponseStatusException" for deleteUserById Service directly at Service Layer 
 - Step4: Implement "ResponseStatusException" for createUser Service 
 - Step5: Implement HTTP Status code - 201 Created and Location Header with user path for CreateUser Service 
   
    
    
        
                         
