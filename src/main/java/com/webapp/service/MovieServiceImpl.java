package com.webapp.service;

import com.webapp.domain.Movie;
import com.webapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository repository;

    @Override
    public boolean exists(Long id) {
        return repository.exists(id);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void delete(Movie movie) {
        repository.delete(movie);
    }

    @Override
    public void delete(Iterable<? extends Movie> movies) {
        repository.delete(movies);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Movie getOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<Movie> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Movie> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Iterable<Movie> findAll(Iterable<Long> ids) {
        return repository.findAll(ids);
    }

    @Override
    public <S extends Movie> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public <S extends Movie> Iterable<S> save(Iterable<S> entities) {
        return repository.save(entities);
    }
}
