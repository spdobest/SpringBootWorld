# Spring Boot - Dynamic Filtering
## Dynamic Filtering 
- We are going to use MappingJacksonValue to implement dynamic filtering
- @JsonFilter applied at Model class with filtername.
- Rest all logic related to filtering will be defined in service or controller
layer.
- Use Case-1: We will first implement it with a basic hash set
- Use Case-2: We will send fields using REST service service query parameters
to retrieve the data for those respective fields.
  
## STEPS TO IMPLEMENT
- Step-00: INtroduction
- Step-01: New GIT branch
    - git Branch Name : Udemy-Springboot9-2-filtering-MappingJacksonValue
    - Create new local branch
- Step-02: Dynamic Filtering using MappingJacksonValue class
    - Controller Layer
        - Create a new UserMappingJacksonController
    - UserMappingJacksonController
        - Implement filtering with static hashset
        - Test it
        - Convert the same to a dynamic filtering by using @RequestParam
        - Test it 
- Step-03: Commit code
    - commit and push code               