# Spring Boot - HATEOAS
NOTE - the video is depricated for hateoas, for depricated classses use below  
https://stackoverflow.com/questions/25352764/hateoas-methods-not-found
  
- HATEOAS is an extra level upon REST
- It is used to present information about a REST API to a client without
the need to bring up the API documentation
- It includes links in a returned response and client can use those API links
to further communicate with the server.
- Simplify the client by making the API discoverable.
      
## Spring Boot HATEOAS  
- Spring HATEOAS provides 3 abstractions for creating the URI  
    - Resource Support
    - Link
    - ControllerLinkBuilder
- We can use these to build the API URL's and associate it to the resource.
- We extend entities( User, Order ) from the Resource Support class to inherit
the add() method
- Once we create a link, we can easily associate that link to a resource 
representation without adding any new fields to the resource or
without writing huge amount of manual boilerplate code.
  
## Spring Boot - HATEOAS implementation steps
- STEP 00: Create git branch for Spring Boot HATEOAS
- STEP 01: Add HATEOAS dependency in pom.xml
- STEP 02: Extends both Entities(user,order) to ResourceSupport
- STEP 03: Create new User and Order controllers for HATEOAS implementation
    - UserHateOasController
    - OrderHateOasController 
- STEP 04: Implement self link in getUserById method
- STEP 05: Implement self and relationship links in getAllUsers Method.
Relationship link will be with getAllOrders method.
    - (A) - Self Link for each user
    - (B) - Relationship link with getAllOrders
    - (C) - Self Link for getAllUsers
- STEP 06: GIT commit code  
  
## STEP 01: Add Dependency in pom.xml
- Add dependency in pom.xml (spring-boot-starter-hateoas)
- Restart SpringBootApp ( to reflect new dependency changes - new jar added )   
  
## STEP 02: Extend both Entities to ResourceSupport
- Entity Layer
    - User extends ResourceSupport
    - Order extends ResourceSupport
  
## STEP 03: Create new User and Order Controllers for HATEOAS implementation
- UserHateOasController
    - Create new class UseHateOasController
    - Annotate with @RestController
    - Annotate with @RequestMapping(value="hateoas/users")
    - Annotate with @Validated
    - Autowire Repositories ( UserRepository )
    - Copy Methods getUserById, getAllUsers from UserController
- OrderHateOasController
    - Create new class OrderHateOasController
    - Annotate with @RestController
    - Annotate with @RequestMapping(value="hateoas/users")
    - Annotate with @Validated
    - Autowire Repositories ( UserRepository,OrderRepository )
    - Copy Methods getAllOrders from OrderController    
- Test with POSTMAN
    - getUserById
        - GET /hateoas/users/{userid}
    - getAllUsers
        - GET /hateoas/users/{userid}
    - getAllOrders
        - GET /hateoas/users/{userid}/orders    
  
## STEP 04: Implement self link in getUserById Method
- UserHateOasController  
    - getUserById - self Linking
    - Method: getUserById
        - Extract UserId
        - Create Link using ControllerLinkBuilder
        - Add Link to Resource<User> ( Return type changed to Resource )
- Test Using POSTMAN
    - Method: getUserById
    - GET /hateoas/users/{userid}  
  
## STEP 05: Implement self and relationship links in getAllUsers Method in UserHateoasController
- 5(A) Self Link for each user in a for loop
    - UserHateOasController
    - Method: getAllUsers
    - HATEOAS: implement self linking for each user
        - For Loop
        - Extract User
        - Create Link with ControllerLinkBuilder
        - Add Link
        - Change Return Type from List<User> to EntityModel<User>  
- Test Using POSTMAN
    - Method: getAllUsers
    - GET /hateoas/users
- 5(B) Relationship Link  with getAllOrders
    - UserHateOasController & OrderHateOasController
    - Method: getAllUsers
    - HATEOAS: implement relationship linking getAllOrders
    - OrderHateOasController
        - Change getAllOrders method return type to EntityModel<Order> from List<Order>
    - UserHateOasController
        -  
- Test Using POSTMAN
    - Method: getAllUsers
    - GET /hateoas/users   