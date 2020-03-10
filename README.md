# Springboot
Documentation of SPRINGBOOT for beginners.
its provide a ready made web application project where all the configuration done itself and provide one ready project.Internally it maintain to provide Web server like **TOMCAT or GLASSFISH**. You no need to manually setup server for web application developed in springboot.    
## Here are the main concept of spring Boot  
1. Dependency Injection.  
2. Annotation Processor  
3. 

## SPRING SUITE AND SPRING TOOLS 
(IDE- Integrated Development Environment)  
### IDE  
1. NetBeans  
2. Eclipse  
3. Spring Tool Suite (STS)  
  
You can download **Spring STS** from the link below  
**https://spring.io/guides/gs/sts/**  
    
For Example if we want to buidl a laptop we need different parts from different companies. To assesmble them and make the laptop will take a lop of effort. For that there is a dependency between all the parts used to develop an laptop.
Same as laptop if we build a project there are different modules are needed and there must be a dependency between each other.    
**Loose Coupling** If One object is not completely dependent on another object. WE can use one object instead of another. This is known as Loose Coupling. LEts for example, while assembling HP laptop, we can use Hard disk of any company(Samsung, HP,ASUS). So this is known as Loose Coupling.  
  
**Tight Coupling** When a object or classes is totaly dependent on another class and we cant use other class/object instead of the class. THis is known as Tight Coupling. FOr Apple Laptop only Apple harddisk is required to assemble it. So this is tight coupling.  
  
**In spring object's are provided by another dependency container. In spring all the dependency objects are provided by Soring Container. THis is nothing but Dependency Injection.**  
  
**SpringBoot terms**  
**1. @Component** - 
**2. @AutoWired**-
**3. @Controller**-
**2. @SpringBootApplication**-
**2. @RequestMapping("/login")**-
**2. @ResponseBody**-
**2. @RequestMapper**-
**2. ModelAndView**-
**2. @AutoWired**-
**2. @AutoWired**-
**2. @AutoWired**-

**@Bean -** indicates that a method produces a bean to be managed by Spring.  
**@Service -** indicates that an annotated class is a service class.  
**@Repository -** indicates that an annotated class is a repository, which is an abstraction of data access and storage.  
**@Configuration -** indicates that a class is a configuration class that may contain bean definitions.  
**@Controller -** marks the class as web controller, capable of handling the requests.  
**@RequestMapping -** maps HTTP request with a path to a controller method.  
**@Autowired -** marks a constructor, field, or setter method to be autowired by Spring dependency injection.  
**@SpringBootApplication -** enables Spring Boot autoconfiguration and component scanning.  
**@Component** is a generic stereotype for a Spring managed component. It turns the class into a Spring bean at the auto-scan time. Classes decorated with this annotation are considered as candidates for auto-detection when using annotation-based   configuration and classpath scanning.   
**@Repository, @Service, and @Controller** are specializations of @Component for more specific use cases.  
  
There are also Hibernate **@Entity, @Table, @Id, and @GeneratedValue** annotations in the example.  
  
  
