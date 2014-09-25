package com.dasiubat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * Created by adam-bat-usr on 25/09/2014.
 */
@NoRepositoryBean
interface BaseRepository<T> extends CrudRepository<T, Long> {
    T findOne(Long id);
}
