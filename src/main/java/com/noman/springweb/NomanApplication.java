package com.noman.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class NomanApplication {

    public static void main(String[] args) {
        SpringApplication.run(NomanApplication.class, args);
    }

}
