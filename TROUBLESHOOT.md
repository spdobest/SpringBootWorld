# Problem and Solutions i faced during Spring Boot  
  
1. This application has no explicit mapping for /error, so you are seeing this as a fallback.  
**Reason-** All the webpages (html, jsp) should be in the path. **src/main/webapps/pages/**. And define the path in the  
application.properties file.  
``` 
spring.mvc.view.prefix=/pages/
spring.mvc.view.suffix=.jsp
```   
2. Error While Loading h2 database in web browser.(http://localhost:8080/h2-console).    
**Connection is broken: "java.net.ConnectException: Connection refused (Connection refused): localhost" [90067-200] 90067/90067**  
**Solutions** Define database properties inside application.properties file like below  
``` 
spring.h2.console.enabled=true
spring.datasource.platform=h2
spring.datasource.url=jdbc:h2:mem:spmDatabase
```   
put **jdbc:h2:mem:spmDatabase** in JSBC URL.  
  
  
