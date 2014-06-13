package com.dasiubat.repository;

import com.dasiubat.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Adam on 2014-05-06.
 */

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
