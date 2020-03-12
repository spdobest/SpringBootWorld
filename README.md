# H2 Database 
  
## What is H2 Database ?   
H2 is one of the popular in-memory databases written in Java. It can be embedded in Java applications or run in the client-server mode.  
Spring Boot provides excellent integration support for H2 using simple properties configuration.   
To make it even more useful, H2 also provides a console view to maintain and interact with the database tables and data.  
  

## Add the below Dependency  
```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
        <version>2.1.4.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
        <version>1.4.199</version>
    </dependency>
```  
By design, the in-memory database is volatile and data will be lost when we restart the application.  
We can change that behavior by using file-based storage. To do this we need to update the spring.datasource.url:
```
spring.datasource.url=jdbc:h2:file:/data/demo
```  
## H2 Configuration  
By default, Spring Boot configures the application to connect to an in-memory store with the username sa and an empty password. However, we can change those parameters by adding the following properties to the application.properties file:
  
```  
application.properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect 
```  
##  Configure data persistence  
The in-memory databases are volatile, by default, and all stored data will be lost when we restart the application. In this case, data is written in temporary memory and as soon as JVM is stopped, data is flushed.  
``` 
     application.properties
     # temporary data storage
     spring.datasource.url = jdbc:h2:mem:testdb
      
     # temporary data storage
     spring.datasource.url = jdbc:h2:file:/data/sample
     spring.datasource.url = jdbc:h2:file:C:/data/sample (Windows only)
``` 
## Create schema and insert data on initialization  
We may want to initialize database with some fixed schema (DDL) and insert default data (DML) into tables before the application is ready is run business usecases.
  
We can achieve this by putting sql files into resources folder (/src/main/resources/).
  
schema.sql – To initialize the schema ie.create tables and dependencies.
data.sql – To insert default data rows.
**schema.sql**  
```
DROP TABLE IF EXISTS TBL_EMPLOYEES;
  
CREATE TABLE TBL_EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);
```  
**data.sql**  
```
INSERT INTO TBL_EMPLOYEES (first_name, last_name, email) VALUES
  ('Lokesh', 'Gupta', 'abc@gmail.com'),
  ('Deja', 'Vu', 'xyz@email.com'),
  ('Caption', 'America', 'cap@marvel.com');
```
## Database Operations  
Carrying out CRUD operations with H2 within Spring Boot is the same as with other SQL databases and our tutorials in the Spring Persistence series does a good job of covering this.
  
In the meantime, let's add a data.sql file in src/main/resources:  
  
## Accessing the H2 Console  
H2 database has an embedded GUI console for browsing the contents of a database and running SQL queries. By default, the H2 console is not enabled in Spring. So to enable it, we need to add the following property to application.properties:  
```
application.properties
# Enabling H2 Console
spring.h2.console.enabled=true
 
# Custom H2 Console URL
spring.h2.console.path=/h2 
```  
Then, after starting the application, we can navigate to **http://localhost:8080/h2-console** which will present us with a login page. On the login page, we'll supply the same credentials as we used in the application.properties:

Moreover, we can further configure the console by specifying the following properties in the project's application.properties with our desired values:

```  
spring.h2.console.path=/h2-console
spring.h2.console.settings.trace=false
spring.h2.console.settings.web-allow-others=false
```  
 
## https://howtodoinjava.com/spring-boot2/h2-database-example/ 
  
## lombok in Spring boot  
**For More details : https://springframework.guru/spring-boot-with-lombok-part-1/**     
**@Data  
@Value  
@NoArgsConstructor  
@AllArgsConstructor   
@RequiredArgsConstructor  
@Getter  
@Setter  
@NotNull  
val and var**
 ```  
<dependency>
   <groupId>org.projectlombok</groupId>
   <artifactId>lombok</artifactId>
   <version>1.18.8</version>
   <scope>provided</scope>
</dependency>
```  
 


