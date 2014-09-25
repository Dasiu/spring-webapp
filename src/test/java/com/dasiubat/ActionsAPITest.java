package com.dasiubat;

import com.dasiubat.config.DBConfigurationTest;
import com.dasiubat.config.MvcConfiguration;
import com.dasiubat.controller.ActionController;
import com.dasiubat.domain.Action;
import com.dasiubat.domain.Movie;
import com.dasiubat.service.ActionService;
import com.dasiubat.service.MovieService;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.when;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Adam on 2014-06-09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MvcConfiguration.class, DBConfigurationTest.class})
@Transactional
public class ActionsAPITest {
    @Autowired
    private ActionController actionController;

    @Autowired
    private ActionService actionRepository;

    @Autowired
    private MovieService movieRepository;
    private Movie[] movies;
//    private Action[] movies;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(actionController);
        movies = twoSampleMovies();
    }

    @Test
    public void getActionsIdShouldReturnAction() {
//        Action response = when().get("/actions/" + movies[0].getId())
//                .then().statusCode(200).contentType(ContentType.JSON)
//                .extract().as(Movie.class);
//
//        assertEquals(movies[0], response);
    }

    private Movie[] twoSampleMovies() {
        Movie batman = new Movie();
        batman.setTitle("Batman");
        movieRepository.save(batman);

        Movie psy = new Movie();
        psy.setTitle("Psy");
        movieRepository.save(psy);

        return new Movie[]{batman, psy};
    }
}
