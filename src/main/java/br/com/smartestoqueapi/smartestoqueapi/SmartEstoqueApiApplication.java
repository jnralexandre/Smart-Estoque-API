package br.com.smartestoqueapi.smartestoqueapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.smartestoqueapi.smartestoqueapi")
public class SmartEstoqueApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartEstoqueApiApplication.class, args);
    }
}