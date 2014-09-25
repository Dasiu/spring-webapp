package com.dasiubat.repository;

import com.dasiubat.domain.actions.Action;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Adam on 2014-05-06.
 */

public interface ActionRepositoryCustom {
    /**
     * loads entity from db in separate session
     */
    public Action findOriginalOne(Long id);
}
