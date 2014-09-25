package com.dasiubat.service;

import com.dasiubat.domain.Movie;
import com.dasiubat.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Adam on 2014-05-06.
 */

@Service
@Transactional
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    Movie findOriginalOne(Long id) {
        return movieRepository.findOriginalOne(id);
    }

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findOne(Long id) {
        return movieRepository.findOne(id);
    }

    public void delete(Long id) {
        movieRepository.delete(id);
    }

    public boolean exists(Long id) {
        return movieRepository.exists(id);
    }

    public long count() {
        return movieRepository.count();
    }
}
