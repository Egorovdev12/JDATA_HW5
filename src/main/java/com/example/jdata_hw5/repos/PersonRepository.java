package com.example.jdata_hw5.repos;

import com.example.jdata_hw5.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByCityOfLiving(String cityOfLiving);
    List<Person> findByAgeIsLessThan(int age);
    Optional<List<Person>> findByNameAndSurname(String name, String surname);
}
