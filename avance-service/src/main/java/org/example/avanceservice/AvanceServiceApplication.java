package org.example.avanceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableFeignClients
@SpringBootApplication
public class AvanceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvanceServiceApplication.class, args);
    }

}
