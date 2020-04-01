## Spring Boot Admin
- Spring boot Admin server is a web application used for managing and
monitoring spring boot applications.
- It is available as a war packages so it can be deployed to any of the
JVMS ( example: tomcat )
- Each application is considered as a client and registers to spring boot admin server.
- In the background, all the data displayed on Admin Server is using
Spring Boot Actuator endpoints enabled on client application.
## Spring Boot Admin Server Features
- Features
    - Dashboard with desktop notifications.
    - View application health, info and details fetched using actuator endpoints
    - Configure & View Metrics (Live only)
    - View log files
    - Manage logback logger levels
    - View and use JMX beans via jolokia
    - View Thread dump
    - View HTTP request Traces (Live only)
    - View history of registered applications
    - Notifications is the top notch key feature (can notify in many ways)
    - All in it's a Live monitoring and alerting solution                     
- Cons
    - Time series data is not available. It doesn't store data.
## Spring Boot Admin Server - Notification
- Reminder Notifications
- Filtering Notifications
- Mail Notifications
- Reminder Notifications
- PageDuty Notifications
- OpsGenie Notifications
- HipChat Notifications
- Slack Notifications
- Let's Chat Notifications
- Microsoft Teams Notifications
- Telegram Notifications
- Discord Notifications
## Spring Boot Admin Server - Steps
- Step-01: Spring Boot Admin Server - Base project setup
- Step-02: Point spring Boot Client Application to Admin Server
- Step-03: Test the features in Spring Boot Admin Server
## Spring Boot Admin Server - Details Implementation Steps
- Step-01: Spring Boot Admin Server - Base project setup
    - Create new SpringBoot Project from SpringBoot Initializer
    - Add Dependencies
        ``` 
            <dependency>  
                <groupId>de.codecentric</groupId> 
                <artifactId>spring-boot-admin-starter-server</artifactId> 
                <version>2.1.6</version> 
            </dependency>   
       ```
    - Annotate with @EnableAdminServer for Springboot main application class file
    - Change the port to 9080
        - application.properties - server.port=9080
    - Access Springboot Admin Server
        - http://localhost:9080
    - Reference
        - http://codecentric.github.io/spring-boot-admin/2.1.6/#getting-started
- Step-02: Point Springboot client Application (SpringBoot-BuildingBlocks project)
    - Add Spring Boot admin dependency
      ``` 
         <dependency>  
            <groupId>de.codecentric</groupId> 
            <artifactId>spring-boot-admin-starter-client</artifactId> 
            <version>2.1.6</version> 
         </dependency>   
      ```                     
    - application.properties
        - spring.boot.admin.client.url=http://localhost:9080
        - management.endpoints.web.exposure.include=*
    - Also supports Springboot Cloud Discovery and equivelent client dependency available too.
    - Add Tags for instances
        -  using the metadata
           spring.boot.admin.client.instance.metadata.tags.environment=dev
        - Using the info endpoint
           info.tags.environment=dev
    - Restart Embedded Tomcat
    - Test SpringBoot Admin Server                     
- Step-03: Test the features in Spring Boot Admin Server
    - Insights
        -> Details - Actuator Health Endpoint
        -> Metrics - Actuator Metrics Endpoint
    - It Gores on this way with all actuator endpoints.
    - Web
        - Http Traces (Run POSTMAN request runner in parallel to monitor)
        

   