# Spring Boot - Filtering
## Static Filtering
- @JsonIgnore will be applied at Field level in a model class (Entity).
- @JsonIgnoreProperties will be applied class level in a model class and we can
define list of fields that can be ignored
- Simply hides the field from the Jackson Parser.
- Cons
    - Create or Update requests will fail after applying these annotations(POST, PUT)  
  
## STEPS TO IMPLEMENT
- Step-00: Introduction
- Step-01: New GIT branch
    - git Branch Name : Udemy-Springboot9-filtering
    - Create new local branch
- Step-02: Static Filtering
    - Entity Layer
        - @JsonIgnore - Apply to SSN fields
        - Test
        - @JsonIgnoreProperties - Apply to role and email
        - Test
- Step-03: Commit code
    - commit and push code               