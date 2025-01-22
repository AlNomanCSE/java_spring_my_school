package org.noman.myschool;

import org.noman.myschool.beans.Vehicle;
import org.noman.myschool.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle bmwBean = context.getBean("BMW",Vehicle.class); //Vehicle.class is the binay file name after compilation of Vechicle.java

//        ProjectConfig itself becomes a bean in the Spring IoC container!

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("--------------------------------");
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

//        Spring does two things:
//
//        Uses it as a source of bean definitions
//        Also creates a bean of ProjectConfig class itself

//        You can even access the configuration bean:

        // Get the configuration bean
        ProjectConfig config = context.getBean(ProjectConfig.class);
        // OR
        ProjectConfig config2 = (ProjectConfig) context.getBean("projectConfig");

        System.out.println(config); // Will print something like: org.noman.myschool.config.ProjectConfig$$SpringCGLIB$$0
//        org.noman.myschool.config.ProjectConfig$$SpringCGLIB$$0@1189dd52
    }
}