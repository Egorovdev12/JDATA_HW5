package com.example.jdata_hw5.controllers;

import com.example.jdata_hw5.entities.Person;
import com.example.jdata_hw5.exceptions.PersonNotFoundException;
import com.example.jdata_hw5.repos.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    private PersonRepository personRepository;

    public Controller(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    public String getPersonsByCity(@RequestParam String city) {
        return personRepository.findByCityOfLiving(city).toString();
    }

    @GetMapping("/persons/by-age")
    public String getPersonsByAge(@RequestParam int age) {
        return personRepository.findByAgeIsLessThan(age).toString();
    }

    @GetMapping("/persons/byNameAndSurname")
    public List<Person> getPersonsByNameAndSurname(@RequestParam String name, String surname) throws PersonNotFoundException {
        return personRepository.findByNameAndSurname(name, surname).orElseThrow(() -> new PersonNotFoundException());
    }
}