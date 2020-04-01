package spm.spring.client.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getAPiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("spm.spring.world"))
//                .paths(PathSelectors.any())   // if you want to see all the api list
                .paths(PathSelectors.ant("/users/**")) // if you want to see only user reletaed apis
                .build();
    }
    // Swagger Metadata : http://localhost:8080/v2/api-docs
    //  Swagger UI URL :  http://localhost:8080/swagger-ui.html

    private ApiInfo getAPiInfo() {
        return new ApiInfoBuilder()
                .title("spdobest User Management Service")
                .description("This page lists all the API's of User management")
                .version("2.0")
                .contact(new Contact("Sibaprasad", "https://www.spdobest.com", "sp.dobest@gmail.com"))
                .license("Licence 2.0")
                .licenseUrl("www.licence.com")
                .build();
    }
}
