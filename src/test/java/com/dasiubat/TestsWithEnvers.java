package com.dasiubat;

import com.dasiubat.config.DBConfigurationTest;
import com.dasiubat.config.MvcConfiguration;
import com.dasiubat.domain.ActionRevision;
import com.dasiubat.domain.ActionTypeHolder;
import com.dasiubat.domain.Director;
import com.dasiubat.domain.Movie;
import com.dasiubat.domain.enums.Action;
import com.dasiubat.service.DirectorService;
import com.dasiubat.service.MovieService;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditQuery;
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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * Created by Adam on 2014-06-09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MvcConfiguration.class, DBConfigurationTest.class})
@TransactionConfiguration(defaultRollback=false)
public class TestsWithEnvers {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MovieService movieService;

    @Autowired
    private DirectorService directorService;

    @Autowired
    private ActionTypeHolder actionTypeHolder;

    private Movie batman = createMovie("Batman", 2010);
    private Movie psy = createMovie("Psy", 2008);

    private Director nolan = createDirector("Nolan");
    private Director komasa = createDirector("Komasa");

    private Director createDirector(String name) {
        Director director = new Director();
        director.setName(name);
        return director;
    }

    @PostConstruct
    public void init() {
        transaction1();
//        transaction2();
        transaction3();
//        transaction4();
//        transaction5();
    }

    @Test
    @Transactional
    public void enversTest() {
//        CriteriaQuery crtieriaQuery = entityManager.getCriteriaBuilder().createQuery(ActionRevision.class);
        Query query = entityManager.createNativeQuery("SELECT * FROM envers.actionrevision WHERE action IN ('CALENDAR')",
                ActionRevision.class);

        List<ActionRevision> actionRevisions = query.getResultList();
        AuditReader reader = AuditReaderFactory.get(entityManager);
//        AuditQuery auditQuery = reader.createQuery().forRevisionsOfEntity(Movie.class, false, true);
//        List<?> objects = auditQuery.getResultList();

        Action action = Action.MESSAGE;
        boolean flag = action.isConnectedWithCase();
//        fail("sd");
//        assertNotEquals("success", objects.size(), 0);
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
        directorService.save(komasa);
    }

    @Transactional
    public void transaction4() {
        nolan.setMovie(batman);
        directorService.save(nolan);
    }

    @Transactional
    public void transaction5() {
//        batman.getDirectors().add(komasa);
//        movieService.save(batman);

        komasa.setMovie(batman);
        directorService.save(komasa);
    }

    private Movie createMovie(String title, int year) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        return movie;
    }
}

