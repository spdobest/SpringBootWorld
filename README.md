# Spring Boot - Security
https://www.youtube.com/playlist?list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE  
  
## Though app Server gives security , why application need security ?
- Spring Security provides extra security to your application like
    - Who are you ??
    - What data do you want
## Spring Security
- It is Application Security framework
- You can ask Spring to set Login and Logout Functionality
- Allow/block access to URLs to logged in users.
- Allows/block access to URLs to logged in users AND with certain roles.
## Why Spring Security    
- By adding spring security your application, it will handle lots
of common vulnerability
    - Session fixation
    - Clickjacking
    - Click site request forgery
- Very widely adopted in technology
## What Spring Security    can do ??        
- User name/password authentication
- SSO / Okta / LDAP
- App level Authorization
- Intra App Authorization like OAuth
- Microservice security ( using tokens, JWT )
- Method Level security
## 5 Core Concepts in Spring Security
- Authentication
- Authorization
- Principal
- Granted Authority
- Roles
##  Authentication
Lets consider our Spring Boot web application is a Security Area where we appoint a Security gu  
(Spring Security). The Guard will ask everyone Before entering to the Security Area.  
This is nothing but the Authentication.
## Knowledge Based Authentication
    - User Id, Password
    - Pin code
    - Answer to a secret / Personal Questions.
- Knowledge based Authentication is very easy to implement and also not very safe
- Hackers can hack the user id and password
## Possession Based authentication
- Phone/ Text message
- Key cards and badges
- Access token device
- This is little difficult to hack the password
**NOTE: Few users use Knowledge based and Possession based Authentication to make the
Multi Factor Authentication.**  
##  Authorization
Lets consider our Spring Boot web application is a Security Area where we appoint a Security guard  
(Spring Security). The Guard will ask "What you want ?" Can this user do this ??  
This is nothing but the Authorization.  
      
When Spring security allow/block a user to perform specific task is knowan as
Authorization.   
Authentication :: Who is this User ??  
Authorization :: Are they allowed to do this ??  
  
## Principal
- Currently Logged in User is Principal.
- Once the user authenticated, now the application consider the user as Principal.
- The application does not ask for multiple time Authentication.
## Granted Authority
- Spring Security granted authority to  specific operations for users.
- Apart from those granted operations user cant do other stuffs.
- This is done by the Spring Security. This is known as Granted Authority
## Roles
- Lets take an example of store management.
- there are few roles assigned to few employees 
- Store Manager - have the role to access all the roles
- Store keeper - have the role to access the store the product in the store
# How to add Spring Security to Spring boot
- Add Spring Security dependency in pom.xml file
    ```
            <dependency>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-starter-security</artifactId>
    		</dependency>
    ```
        