package com.lab.gs_accessing_data_jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

//clase que permite hacer consultas a la BD
//Con springJPA no se debe crear la implementacion de esta interfaz, se crea cuando se corre la app
//Se crean metodos que deban ser "personalizados"
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    //Consultar los usuarios que tengan un nombre especifico
    List<Customer> findByLastName(String lastName);

    //Consulta un cliente que cumpla con el id ingresado
    Customer findById(long id);
}
