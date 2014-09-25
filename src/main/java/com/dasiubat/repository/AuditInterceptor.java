package com.dasiubat.repository;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;

/**
 * Created by adam-bat-usr on 25/09/2014.
 */
public class AuditInterceptor extends EmptyInterceptor {
    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
//        System.out.println("hello");
        throw new UnsupportedOperationException();
//        return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }
}
