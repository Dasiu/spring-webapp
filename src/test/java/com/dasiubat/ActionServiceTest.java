package com.dasiubat;

import com.dasiubat.config.DBConfigurationTest;
import com.dasiubat.config.MvcConfiguration;
import com.dasiubat.domain.CustomObject;
import com.dasiubat.domain.Movie;
import com.dasiubat.domain.actions.Action;
import com.dasiubat.domain.actions.MovieEditedAction;
import com.dasiubat.service.ActionService;
import com.dasiubat.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import static org.junit.Assert.fail;

/**
 * Created by Adam on 2014-06-09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MvcConfiguration.class, DBConfigurationTest.class})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class ActionServiceTest {
    @Autowired
    private ActionService actionService;

    @Autowired
    private MovieService movieRepository;
    private Movie[] movies;
//    private Action[] movies;

    @PostConstruct
    @Transactional
    public void init() {
        movies = twoSampleMovies();
    }

    @Before
    public void setup() {
//        movies = twoSampleMovies();
    }

    @Test
    public void archiveShouldDetectAndStoreChanges() {
        Movie batman = movies[0];
        batman.setTitle("Revenge");
        CustomObject customObject = new CustomObject();
        customObject.setAtr("sdf");
        customObject.setNum(1);
        batman.setCustomObject(customObject);

        MovieEditedAction movieEditedAction = new MovieEditedAction();
        actionService.audit(movieEditedAction, batman.getClass(), batman);
    }

    @Test
    public void archiveShouldDoNothingWhenEntityDoesntChange() {
        fail("not implemented");
    }

    @Test
    public void archiveShouldThrowFieldDoesntExist() {
        fail("not implemented");
    }

    @Test
    public void archiveShouldThrowIfTypeInferenceDoesntWork() {
        fail("not implemented");
    }

    @Test
    public void archiveArgsShouldBeNotNull() {
        fail("not implemented");
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
