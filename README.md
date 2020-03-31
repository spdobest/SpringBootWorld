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
- Step-02: Static Filtering
    - Entity Layer
        - @JsonIgnore - Apply to SSN fields
        - Test
        - @JsonIgnoreProperties - Apply to role and email
        - Test
- Step-03: Commit code
    - commit and push code                  