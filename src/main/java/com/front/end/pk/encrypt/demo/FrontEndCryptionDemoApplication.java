package com.front.end.pk.encrypt.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * creating a spring mvc app with spring boot 1.5 using apache tiles 3 layout. 
 * We will be creating different reusable page fragments such as header, body, 
 * footer using jsp and assemble them in a single jsp page at runtime using configuration file tiles.xml.
 * Also, we will check how to make use of ModelAndView attributes in JSP while using apache tiles.
 */
/*
 * SpringBootServletInitializer configure deloy war to tomcat provider
 * SpringBootServletInitializer enables process used in Servlet 3.0 using web.xml
 * 
 * @SpringBootApplication Equivalent to using @Configuration, @EnableAutoConfiguration 
 * and @ComponentScan with their default attributes:
 * <=Springboot 1.5.9, add  extends SpringBootServletInitializer to make sure deploying war to tomcat to be able to run
 * >Spring 2.1.3 do not need it any more and Spring 2.1.3 can run spring boot's cloud oauth2 and security 
 * 
 */

/**
   http://localhost:8080/FrontEndPublicKeyEncryption/signup
   http://localhost:8080/FrontEndPublicKeyEncryption/update/{username}
 */
@SpringBootApplication
public class FrontEndCryptionDemoApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(FrontEndCryptionDemoApplication.class, args);
    }

    @Override  // after Spring boot 2.0 do not need it 
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FrontEndCryptionDemoApplication.class);
    }

}