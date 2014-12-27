package com.webapp.service;

public interface BaseService<T> {

    boolean exists(Long id);


    T findOne(Long id);


    long count();

    void save(T t);


    Iterable<T> findAll();

    void delete(Long id);
}
