package dev.knapp.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200");
                /*.allowedMethods("*")https://www.javaguides.net/2019/09/spring-boot-cors-crossorigin-example.html
                .allowedHeaders("*")
                .allowCredentials(false)
                .maxAge(3600);*/
    }
}
