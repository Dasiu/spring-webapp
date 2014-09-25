package com.dasiubat.repository;

import com.dasiubat.domain.actions.Action;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Adam on 2014-05-06.
 */

@Repository
public class ActionRepositoryImpl implements ActionRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Action findOriginalOne(Long id) {
        Session session = getSessionFactory().openSession(); // TODO check if it should be closed explicitly
        return (Action) session.get(Action.class, id);
    }

    private SessionFactory getSessionFactory() {
        return entityManager.unwrap(Session.class).getSessionFactory();
    }
}
