package com.webapp.service;

import com.webapp.domain.Movie;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BaseService {
    @Transactional(readOnly = true)
    boolean exists(Long id);

    @Transactional(readOnly = true)
    Movie findOne(Long id);

    @Transactional(readOnly = true)
    long count();

    void save(Movie movie);

    @Transactional(readOnly = true)
    Iterable<Movie> findAll();

    void delete(Long id);
}
