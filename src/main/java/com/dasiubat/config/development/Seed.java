package com.dasiubat.config.development;

import com.github.javafaker.Faker;
import com.dasiubat.repository.PersonRepository;
import com.dasiubat.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Adam on 2014-05-03.
 */
@Component
public class Seed {
    @Autowired
    private PersonRepository personRepository;

    private static final Faker faker = new Faker();

    @PostConstruct
    public void seed() {
        createPersons(100);
    }

    public void createPersons(Integer num) {
        for (int i = 0; i < num; i++) {
            personRepository.save(generatePerson());
        }
    }

    private Person generatePerson() {
        Person person = new Person();
        person.setName(faker.firstName());
        person.setSurname(faker.lastName());

        return person;
    }
}
