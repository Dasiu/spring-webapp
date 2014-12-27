package com.webapp.controller;

import com.webapp.domain.Movie;
import com.webapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MovieControllerImpl implements MovieController {
    @Autowired
    private MovieService movieService;

    @Override
    public Iterable<Movie> index() {
        return movieService.findAll();
    }

    @Override
    public Map<String, Long> create(@RequestBody Movie movie) {
        movieService.save(movie);
        Map<String, Long> response = new HashMap<>();
        response.put("id", movie.getId());

        return response;
    }

    @Override
    public Movie show(@PathVariable Long id) {
        return movieService.findOne(id);
    }

    @Override
    public void update(@PathVariable Long id, @RequestBody Movie movie) {
        movie.setId(id);
        movieService.save(movie);
    }

    @Override
    public void destroy(@PathVariable Long id) {
        movieService.delete(id);
    }
}
