package org.noman.myschool;


import org.noman.myschool.beans.Vehicle;
import org.noman.myschool.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle bean = context.getBean(Vehicle.class);
        System.out.println(bean.getName());
    }
}