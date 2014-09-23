package com.dasiubat.service;

import com.dasiubat.domain.Director;
import com.dasiubat.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Adam on 2014-05-06.
 */

@Transactional
public class TestDataService {
    @Autowired
    private MovieService movieService;

    @Autowired
    private DirectorService directorService;

    private Movie batman = createMovie("Batman");
    private Movie psy = createMovie("Psy");

    private Director nolan = createDirector("Nolan");

    private Director createDirector(String name) {
        Director director = new Director();
        director.setName(name);
        return director;
    }

    public void setup() {
        transaction1();
        transaction2();
        transaction3();
    }

    @Transactional
    public void transaction1() {
        movieService.save(batman);
    }

    @Transactional
    public void transaction2() {
        movieService.save(psy);
    }

    @Transactional
    public void transaction3() {
        directorService.save(nolan);
    }

    private Movie createMovie(String title) {
        Movie movie = new Movie();
        movie.setTitle(title);
        return movie;
    }
}
