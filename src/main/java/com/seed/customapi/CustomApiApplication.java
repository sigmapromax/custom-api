package com.seed.customapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.seed.customapi.*.mapper")
@SpringBootApplication
public class CustomApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomApiApplication.class, args);
    }

}
