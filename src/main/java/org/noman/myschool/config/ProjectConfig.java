package org.noman.myschool.config;

import org.noman.myschool.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean(name = "Audi")
    Vehicle vehicle1() {
        var vehicle = new Vehicle();
        vehicle.setName("Audi 8");
        return vehicle;
    }
    @Bean(name = "BMW")
    Vehicle vehicle2() {
        var vehicle = new Vehicle();
        vehicle.setName("BMW");
        return vehicle;
    }


    @Bean
    String hello(){
        return "Hello World";
    }

    @Bean
    Integer number(){
        return 10;
    }
}
