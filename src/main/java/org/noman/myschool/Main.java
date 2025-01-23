package org.noman.myschool;


import org.noman.myschool.beans.Vehicle;
import org.noman.myschool.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Supplier<Vehicle> volkswagenSupplier = () -> {
            Vehicle vehicle = new Vehicle();
            vehicle.setName("Volkswagen");
            return vehicle;
        };
        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle vehicle = new Vehicle();
            vehicle.setName("Audi");
            return vehicle;
        };

            context.registerBean("volkswagen", Vehicle.class, volkswagenSupplier);

            context.registerBean("audi", Vehicle.class, audiSupplier);

        Vehicle volkswagen = null;
        Vehicle audi = null;
        try {
            volkswagen = context.getBean("volkswagen", Vehicle.class);

        } catch (NoSuchBeanDefinitionException e) {
            System.out.println(e.getMessage());
        }
        try {
            audi = context.getBean("audi", Vehicle.class);
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println(e.getMessage());
        }

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("--------------------------------");
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}