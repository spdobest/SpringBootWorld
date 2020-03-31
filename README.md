# Spring Boot - API Versioning And Content Negotiation.
 - URI Versioning
 - Request Parameter Versioning
 - Custom Header Versioning
 - Media Type or Mime Type or Accept Header Versioning
   
## URI versioning
    - http://localhost:8080/versioning/uri/users/v1.0/101   
    - http://localhost:8080/versioning/uri/users/v2.0/101
  
- Request Parameter Versioning
     - http://localhost:8080/versioning/uri/users/v1.0/101?version=1          
     - http://localhost:8080/versioning/uri/users/v1.0/101?version=2
- Custom Header Versioning
    - Pass API-VERSION in header in POSTMAN
- Media Type or Mime Type or Accept Header Versioning
    - header in postmen:
        - Accept = application/vnd.stacksimplify.app-v1+json
        - Accept = application/vnd.stacksimplify.app-v2+json   
          
## API Versioning - Implementation Steps
- Step-01: Create new GIT branch using IDE
- Step-02: Create two DTO's and address fields in User ENtity
- Step-03: Implement URI versioning 
- Step-04: Implement Request Parameter Versioning
- Step-05: Implement Custom Header Versioning 
- Step-06: Implement Media Type Versioning
- Step-07: Commit & Push Code via IDE

## API Versioning - Detailed Implementation Steps
- Step 00: Introduction
- Step-01: New GIT branch
    - git Branch Name : Udemy-Springboot11-Versioning
    - Create new local branch
- Step-02: Create two DTO's and add additional field in Entity named "address"
    - Entity Layer
        - Add new field named city
        - Update the data.sql with address
    - DTO Layer
        - Create two DTO's
            - UserDtoV1 - Contains all other fields except "address"
            - UserDtoV2 - Contains all other fields with  "address" field
- Step-03: Implement URI Versioning
    - Controller Layer
        - Create UserUriVersioningController by copying UserModelMapperController
        - We are going to use ModelMapper to transform Entity to DTO
        - Implement getUserByIdV1 and getUserByIdV2 methods with URI's
        - URI Versions
            - @GetMapping({"/v1.0/{id}","/v1.1/{id}"})                  
            - @GetMapping("/v2.0/{id}")                  
    - Test Using POSTMAN
        - Version V1.0 - GET http://localhost:8080/versioning/uri/users/v1.0/101           
        - Version V1.1 - GET http://localhost:8080/versioning/uri/users/v1.1/101           
        - Version V2.0 - GET http://localhost:8080/versioning/uri/users/v2.0/101
- Step-04: Implement Request Parameter Versioning
    - Controller Layer
        - Create UserRequestParameterVersioningController by copying UserUriVersioningController
        - We are going to use ModelMapper to transform Entity to DTO.
        - Implement getUserByIdv1 and getUserByIdv2 methods with Request Parameters
        - Request Parameters
            - @GetMapping(value = "/{id}",param="version=1")            
            - @GetMapping(value = "/{id}",param="version=2")  
    - Test Using POSTMAN
        - Version V1
            - GET http://localhost:8080/versioning/params/users/101?version=1                  
         - Version V2
            - GET http://localhost:8080/versioning/params/users/101?version=2  
              
- Step-05: Implement Custom Header Versioning
    - Controller Layer
        - Create UserCustomHeaderVersioningController by copying UserRequestParameterVersioningController
        - We are going to use ModelMapper to transform Entity to DTO
        - Implement getUserByIdV1 & getUserByIdV2 methods with custom Headers
        - Custom Headers
            - @GetMapping(value = "/{id}", headers="API-VERSION=1")                                 
            - @GetMapping(value = "/{id}", headers="API-VERSION=2")
    - Test Using POSTMAN
        - Version V1
            - GET http://localhost:8080/versioning/params/users/101
            - Header: API-VERSION = 1               
        - Version V2
            - GET http://localhost:8080/versioning/params/users/101
            - Header: API-VERSION = 2 
- Step-06: Implement Media Type Versioning
    - Controller Layer
        - Create UserMediaVersioningController by copying UserRequestParameterVersioningController
        - We are going to use ModelMapper to transform Entity to DTO
        - Implement getUserByIdV1 & getUserByIdV2 methods with custom Headers
    - Media Type
    - @GetMapping( value = "/{id}", produces="application/vnd.stackssimplify.app-v1+json")                            
    - @GetMapping( value = "/{id}", produces="application/vnd.stackssimplify.app-v2+json")  
    - Test Using POSTMAN
        - Version V1
            - GET http://localhost:8080/versioning/params/users/101
            - Header: Accept = application/vnd.stacksimplify.app-v1+json                    
        - Version V2
            - GET http://localhost:8080/versioning/params/users/101
            - Header: Accept = application/vnd.stacksimplify.app-v2+json   
              
- Step-07: Commit & Push Code to remote branch
                 