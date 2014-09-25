package com.dasiubat.repository;

import com.dasiubat.domain.actions.Action;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * Created by adam-bat-usr on 25/09/2014.
 */
interface BaseRepositoryCustom<T> {
    /**
     * loads entity from db in separate session
     */
    public T findOriginalOne(Long id);

}
