package org.noman.myschool;


import org.noman.myschool.beans.Vehicle;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("beans.xml");
        Vehicle bean = context.getBean(Vehicle.class);
        System.out.println(bean.getName());
    }
}