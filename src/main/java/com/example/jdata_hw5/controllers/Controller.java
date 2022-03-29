package com.example.jdata_hw5.controllers;

import com.example.jdata_hw5.entities.Person;
import com.example.jdata_hw5.services.Service;
import com.example.jdata_hw5.exceptions.PersonNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    private Service service;


    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/persons/by-city")
    public String getPersonsByCity(@RequestParam String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public String getPersonsByAge(@RequestParam int age) {
        return service.getPersonsByAge(age);
    }

    @GetMapping("/persons/byNameAndSurname")
    public List<Person> getPersonsByNameAndSurname(@RequestParam String name, String surname) throws PersonNotFoundException {
        return service.getPersonsByNameAndSurname(name, surname).get();
    }
}