package com.lv.restapibase.controllers;

import com.lv.restapibase.models.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class PassengerController {
    private List<Person> people;

    @GetMapping("/hullo")
    public String getHelloMessage() {
        return "yello";
    }

    @GetMapping("/people")
    public List<Person> getAllPeople() {
        return people;
    }

    @PostMapping("/people")
    @ResponseStatus(HttpStatus.CREATED)
    public Person createNewPerson(@RequestBody Person person) {
        person.setUuid(UUID.randomUUID());
        people.add(person);
        return person;
    }

    @GetMapping("/people/{uuid}")
    public Person getSinglePerson(@PathVariable("uuid") UUID uuid) {
        for (Person person : people) {
            if (uuid.equals(person.getUuid())) {
                return person;
            }
        }
        throw new IllegalArgumentException();
    }

    @DeleteMapping("/people/{uuid}")
    public void deleteSinglePerson(@PathVariable("uuid") UUID uuid) {
        for (Person person : people) {
            if (uuid.equals(person.getUuid())) {
                people.remove(person);
            }
        }
    }

    @PutMapping("/people/{uuid}")
    public void putSinglePerson(@PathVariable("uuid") UUID uuid, @RequestBody Person newPerson) {
        for (Person person : people) {
            if (uuid.equals(person.getUuid())) {

            }
        }
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Request ID not found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler() {
        // Nothing to do
    }
}
