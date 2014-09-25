package com.dasiubat.service;

import com.dasiubat.domain.Action;
import com.dasiubat.domain.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Adam on 2014-05-06.
 */

@Repository
public interface ActionRepository extends CrudRepository<Action, Long> {
}
