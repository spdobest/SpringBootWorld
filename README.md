# Spring Boot - Dynamic Filtering
## JSON View
- @JsonView is used to customize views
- Applied at field level in a model class to categorize which field belongs to which view
- Applied at service level in a controller, so that for that respective
REST service, view defined in @JsonView will be applicable
- Will be very useful if we have a single entity or model which need to 
be provided with different views to different category of clients.
- Course Example: User & Order Management 
    - We have a user entity defined with fields (userid,username,firstname,lastname
    email,role,ssn,orders)
    - Consider we need to present data in 2 view patterns
        - External View: userid,username,firstname,lastname,email
        - Internal View: userid, username,firstname,lastname,email,role,ssn,orders
- Classic Example: Employee Management.(Assignment)
    - We have employee data( empid,name,department,logintime,logoutTime,salary,lastPromotionDate)
    - Consider we need to present employee data in 3 views
        - Normal View: empid, name, department  
        - Manager View: empid, name, department,loginTime, logoutTime  
        - HR View: empid, name, department, salary, lastPromotionDate
  
## Implementation Steps
- Step 00: Introduction
- Step 01: New GIT branch
    - git Branch name: Udemy-Springboot9-3-Filtering-JsonView
    - create new local branch
- Step 02: @JsonView
    - Entity Layer
        - Create a class named Views
            - Create two static classes View (External, Internal)
        - Annotate fields in User Entity with @JsonVIew
        - Decide which fields should be external and internal and annotate accordingly.
    - Controller Layer
        - Create new controller named UserJsonViewController  
        - Copy getUserById method from UserController and create 2 methods
            - External getUserById
                - GET /jsonview/users/external/101
                - Annotate with @JsonView(Views.External.class)
                - Test it using POSTMAN
            - Internal getUserById2
                 - GET /jsonview/users/internal/101
                 - Annotate with @JsonView(Views.Internal.class)
                 - Test it using POSTMAN
                              