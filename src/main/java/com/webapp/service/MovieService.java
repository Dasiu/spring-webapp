package com.webapp.service;

import com.webapp.domain.Movie;

public interface MovieService {
    boolean exists(Long id);

    Movie findOne(Long id);

    long count();

    void save(Movie movie);

    Iterable<Movie> findAll();

    void delete(Long id);
}
