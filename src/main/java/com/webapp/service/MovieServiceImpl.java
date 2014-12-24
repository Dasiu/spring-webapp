package com.webapp.service;

import com.webapp.domain.Movie;
import com.webapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public boolean exists(Long id) {
        return movieRepository.exists(id);
    }

    @Override
    public Movie findOne(Long id) {
        return movieRepository.findOne(id);
    }

    @Override
    public long count() {
        return movieRepository.count();
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        movieRepository.delete(id);
    }
}
