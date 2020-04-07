# Spring Boot - Security
https://www.youtube.com/playlist?list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE  
https://frontbackend.com/spring-boot/spring-boot-startup-failure-because-port-is-already-in-use   
    
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
- after adding the dependency and restart the application, it will show an login screen
without setting any configuration.
## Spring Security Default behaviour
- Add Mandatory authentication for URLs
- Adds login form
- Handles login error (validates login credentials - user name and password)
- Create a user and sets a default password
**NOTE*** if you see the console log, you will see  
Using generated security password: 643ae8d0-8809-4c21-bc00-ad174b5780c5 
and user is the username for the login form
- You can set the User Name and password in application.properties file like below
```
spring.security.user.name=siba
spring.security.user.password=siba
```
- After add this , you will not able to see the password in the spring console log
## How to configure Spring Security Authentication
- Authentication Manager: 
    - It has a method name authenticate()
    - It resides inside Spring Security package
- You will not be dealing with authenticationManager class, you will
deal with AuthenticationManagerBuilder
- AuthenticationManagerBuilder
    - Get hold of AuthenticationManagerBuilder
    - Set the configuration on it
- How to Hold of AuthenticationManagerBuilder
    - Spring Security App have a class which contains method name
    configure(AuthenticationManagerBuilder)
## How to set up your own user id and password
```
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // set my configuration on the auth object
        auth.inMemoryAuthentication()
                .withUser("blah")
                .password("blah")
                .roles("USER");
    }
}
```         
- All passwords are in encoded format in spring security application
- By using Hashing concept, it saves the password
## How to set a Password encoder ?  
Just expose an @Bean of type PasswordEncoder in securityConfiguration Class
```
@Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
```
## How to configure authorization Spring Security
- Add these type of request mapping in controller
```
    @GetMapping("/")
    public String home() {
        return ("<h1>welcome</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>welcome Admin</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>welcome User</h1>");
    }
```
- i SecurityConfiguration Class, add these below line of code
```
 @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // set my configuration on the auth object
        httpSecurity.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }
```
## How Spring Security Authorization Works
- Add spring security filter
```
<filter>
<filter-name>springSecurityFilterChain</filter-name>
<filter-class>org.springframework.web.filter.DelegatingFliterProxy</filter-class>
</filter>
```  
```
<filter-mapping>
<filter-name>springSecurityFilterChain</filter-name>
<filter-class>/*</filter-class>
</filter-mapping>  
```

     