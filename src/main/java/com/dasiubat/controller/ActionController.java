package com.dasiubat.controller;

import com.dasiubat.domain.Action;
import com.dasiubat.domain.Movie;
import com.dasiubat.service.ActionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adam on 2014-06-14.
 */
@RestController
@RequestMapping("/action")
public class ActionController {
    private ActionService actionService;

//    @RequestMapping(method = RequestMethod.GET)
//    public Iterable<Movie> index() {
//        return actionService.findAll();
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Action show(@PathVariable Integer id) {
        return actionService.findOne(id.longValue());
    }
}
