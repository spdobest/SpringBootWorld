# Spring Boot Introduction
- Spring boot made configuring Spring easier with its auto-configuration feature.

## Spring Boot Annotations
- @SpringBootApplication
    - We use this annotation to mark the main class of a Spring Boot application:
- @Bean
    - indicates that a method produces a bean to be managed by Spring.
- @Service
    - indicates that an annotated class is a service class.
- @Repository
    - indicates that an annotated class is a repository, which is an abstraction of data access and storage.
- @Configuration
    - indicates that a class is a configuration class that may contain bean definitions.
- @Controller
    - marks the class as web controller, capable of handling the requests.
- @RequestMapping
    - maps HTTP request with a path to a controller method.
- @Autowired
    - marks a constructor, field, or setter method to be autowired by Spring dependency injection.
- @SpringBootApplication
    - enables Spring Boot autoconfiguration and component scanning.
- @Component
    - is a generic stereotype for a Spring managed component. It turns the class into a Spring bean at the auto-scan time. Classes decorated with this annotation are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.
- PostMaping
- GetMaping
- @RequestBody
- @RequestMapping
- @PutMapping
- @DeleteMapping
- @PathVariable
- @Entity
- @Table
- @Id
- @GeneratedValue
- @Retention(RetentionPolicy.RUNTIME)
- @Documented
- @Inherited
- @Configuration
- @EnableAutoConfiguration
- @ComponentScan
- @Configuration
- @EnableAutoConfiguration
- @ComponentScan
- @ConditionalOnClass
- @ConditionalOnMissingClass
- @ConditionalOnBean
- @ConditionalOnMissingBean
- @ConditionalOnProperty
    - With this annotation, we can make conditions on the values of properties
    - ```
        @Bean
        @ConditionalOnProperty(
            name = "usemysql",
            havingValue = "local"
        )
        DataSource dataSource() {
            // ...
        }
      ```
- @ConditionalOnResource
    - We can make Spring to use a definition only when a specific resource is present:
    -   ```
            @ConditionalOnResource(resources = "classpath:mysql.properties")
            Properties additionalProperties() {
                // ...
            }
        ```
- @ConditionalOnWebApplication and @ConditionalOnNotWebApplication
    - With these annotations, we can create conditions based on if the current application is or isn't a web application
    ```
        @ConditionalOnWebApplication
        HealthCheckController healthCheckController() {
            // ...
        }
    ```
- @ConditionalExpression
    - We can use this annotation in more complex situations. Spring will use the marked definition when the SpEL expression is evaluated to true
    - ```
         @Bean
         @ConditionalOnExpression("${usemysql} && ${mysqlserver == 'local'}")
         DataSource dataSource() {
          // ...
         }
      ```
- @Conditional
    - For even more complex conditions, we can create a class evaluating the custom condition. We tell Spring to use this custom condition with @Conditional
    - ```
        @Conditional(HibernateCondition.class)
        Properties additionalProperties() {
            //...
        }
      ```