package com.lab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Miprimerproyecto implements CommandLineRunner {
    public static void main(String[] args) {
        System.out.println("Bienvenido");
        SpringApplication.run(Miprimerproyecto.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("¡Bienvenido a mi aplicativo en Spring Boot");
    }
}