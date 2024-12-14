package com.system.ophtalmological.System.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//config url that this API will server 
@Configuration
public class ConfigWeb implements WebMvcConfigurer{
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:5173") //ex: Just url like this can access my api 
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*"); //if have any token a shold put here
    }
}
