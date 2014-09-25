package com.dasiubat.domain;

import org.hibernate.Interceptor;
import org.hibernate.ejb.HibernatePersistence;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceUnitInfo;
import java.util.Map;

/**
 * Created by adam-bat-usr on 25/09/2014.
 */
public class HibernatePersistenceWithInterceptor extends HibernatePersistenceProvider {

}

