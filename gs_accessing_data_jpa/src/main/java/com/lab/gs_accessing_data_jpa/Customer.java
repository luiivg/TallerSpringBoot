package com.lab.gs_accessing_data_jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity//indica que es una entidad de JPA, existe una base de datos con una tabla Customer
@Getter//Loombok Permite hacer llamado de los Getter (Obtener los valores de esa variable) sin necesidad de escribir el codigo
public class Customer {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) //valor generado automaticamente
    private Long id;
    private String firstName;
    private String lastName;

    //COnstructor para JPA
    protected Customer() {}

    //Constructor para insstanciar Customer
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
