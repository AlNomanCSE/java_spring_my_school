package org.noman.myschool.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;




@Configuration
@ComponentScan(basePackages = "org.noman.myschool.beans")
public class ProjectConfig {



    @Bean
    String hello(){
        return "Hello World";
    }

    @Bean
    Integer number(){
        return 10;
    }
}
