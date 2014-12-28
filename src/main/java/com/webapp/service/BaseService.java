package com.webapp.service;

import org.springframework.data.domain.Sort;

public interface BaseService<T> {
    boolean exists(Long id);

    long count();

    void delete(Long id);

    void delete(T t);

    void delete(Iterable<? extends T> t);

    void deleteAll();

    T getOne(Long id);

    Iterable<T> findAll();

    Iterable<T> findAll(Sort sort);

    Iterable<T> findAll(Iterable<Long> ids);

    <S extends T> S save(S entity);

    <S extends T> Iterable<S> save(Iterable<S> entities);
}
