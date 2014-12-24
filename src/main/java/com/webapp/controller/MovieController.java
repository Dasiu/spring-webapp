package com.webapp.controller;

import com.webapp.domain.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface MovieController {
    @RequestMapping(method = RequestMethod.GET)
    Iterable<Movie> index();

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    Map<String, Long> create(@RequestBody Movie movie);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Movie show(@PathVariable Integer id);

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void update(@PathVariable Integer id, @RequestBody Movie movie);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable Integer id);
}
