package com.lab.gs_accessing_data_jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GsAccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(GsAccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GsAccessingDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return args -> {
            //Guardar clientes usando la entidad Customer
            repository.save(new Customer("Andres", "Ramirez"));
            repository.save(new Customer("Luisa", "Vargas"));
            repository.save(new Customer("Paola", "Lopez"));
            repository.save(new Customer("Cristian", "Hoyos"));
            repository.save(new Customer("Safo", "Agudelo"));

            //Obtener todos los clientes que existen en la Tabla Customer
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(customer -> {
                log.info(customer.toString());
            });
            log.info("");

            //Buscar clientes por ID en la tabla Customer
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("-------------------------------");
            log.info(customer.toString());
            log.info("");

            //Buscar cliente por el apellido usando el metodo definido en el repositorio findByLastName
            log.info("Customers found with findByLastName('Ramirez'):");
            log.info("-------------------------------");
            //repository.findByLastName("Ramirez").forEach(System.out::println);
            repository.findByLastName("Ramirez").forEach(ramirez -> {
                log.info(ramirez.toString());
            });
            log.info("");
        };
    }

}
