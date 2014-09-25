package com.dasiubat.controller;

import com.dasiubat.domain.ActionTypeHolder;
import com.dasiubat.domain.Director;
import com.dasiubat.domain.Movie;
import com.dasiubat.domain.enums.Action;
import com.dasiubat.service.MovieService;
import com.dasiubat.utils.ContextLookup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adam on 2014-06-14.
 */
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

//    @Autowired
//    private ActionTypeHolder actionTypeHolder;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Movie> index() {
        return movieService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Map<String, Long> create(@RequestBody Movie movie) {
        movieService.save(movie);
        Map<String, Long> response = new HashMap<>();
        response.put("id", movie.getId());

        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Movie show(@PathVariable Integer id) {
        return movieService.findOne(id.longValue());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Movie movie) {
        movie.setId(id.longValue());
        movieService.save(movie);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Integer id) {
        movieService.delete(id.longValue());
    }

    @RequestMapping(value = "/requestScope/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void requestScope(@PathVariable Integer id) {
        // TEST SECTION
        Movie batman = createMovie("Batman", 2010);
        Movie psy = createMovie("Psy", 2008);

        Director nolan = createDirector("Nolan");
        Director komasa = createDirector("Komasa");

        ActionTypeHolder actionTypeHolder = ContextLookup.getBean(ActionTypeHolder.class);
        System.out.println("request scope");
        if (id == 1) {
            actionTypeHolder.setAction(Action.CALENDAR);
            System.out.println("stared waiting");
            movieService.save(batman);
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//
//            }
        } else {
            actionTypeHolder.setAction(Action.CASE);
            movieService.save(psy);
        }

        System.out.println("request scope end");
    }

    private Movie createMovie(String title, int year) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        return movie;
    }

    private Director createDirector(String name) {
        Director director = new Director();
        director.setName(name);
        return director;
    }
}
