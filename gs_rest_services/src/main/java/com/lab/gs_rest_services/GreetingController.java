package com.lab.gs_rest_services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();//Genera un long pequeño

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        //con los valores de entrada, hello lo concatena con el valor que ingrese, si no hay un valor de entrada lo
        // concatena con world
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
