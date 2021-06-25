package com.example.edustructuredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 *  propertysource는  dev,prod에 따라 변경 해준다.
* */

@SpringBootApplication
@PropertySource("classpath:/properties/application-dev.properties")
public class EduStructureDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(EduStructureDemoApplication.class, args);
    }

}
