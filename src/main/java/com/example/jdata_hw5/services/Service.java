package com.example.jdata_hw5.services;

import com.example.jdata_hw5.entities.Person;
import com.example.jdata_hw5.exceptions.PersonNotFoundException;
import com.example.jdata_hw5.repos.PersonRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private PersonRepository repository;

    public Service(PersonRepository repository) {
        this.repository = repository;
    }

    public String getPersonsByCity(String city) {
        return repository.findByCityOfLiving(city).toString();
    }

    public String getPersonsByAge(int age) {
        return repository.findByAgeIsLessThan(age).toString();
    }

    public Optional<List<Person>> getPersonsByNameAndSurname(String name, String surname) throws PersonNotFoundException {
        Optional<List<Person>> personList = repository.findByNameAndSurname(name, surname);
        if (personList.get().isEmpty()) {
           throw new PersonNotFoundException("This user is not found");
        }
        return personList;
    }
}