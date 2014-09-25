package com.dasiubat;

import com.dasiubat.config.DBConfigurationTest;
import com.dasiubat.config.MvcConfiguration;
import com.dasiubat.domain.actions.Action;
import com.dasiubat.domain.actions.MovieEditedAction;
import com.dasiubat.repository.ActionRepository;
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
import java.util.Date;

import static org.junit.Assert.fail;

/**
 * Created by Adam on 2014-06-09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MvcConfiguration.class, DBConfigurationTest.class})
@TransactionConfiguration(defaultRollback = false)
public class ActionRepositoryTest {
    @Autowired
    private ActionRepository actionRepository;
    private Action action;

    @PostConstruct
    public void init() {
        tran1();
        tran2();
    }

    @Transactional
    public void tran2() {
//        Action original = actionRepository.findOriginalOne(1L);
//        original.setCreationDate(new Date(1411642449079L));
    }

    @Transactional
    public void tran1() {
        action = sampleAction();
    }

    @Before
    public void setup() {
//        action = sampleAction();
    }

    @Test
    @Transactional
    public void findOriginalOne() {
        Action original = actionRepository.findOriginalOne(1L);
//        action.setCreationDate(new Date(1411642449079L));

        fail("d");
    }

    private Action sampleAction() {
        Action a = new MovieEditedAction();
        a.setCreationDate(new Date());
        actionRepository.save(a);
        return a;
    }
}
