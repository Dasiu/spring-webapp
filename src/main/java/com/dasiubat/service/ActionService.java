package com.dasiubat.service;

import com.dasiubat.domain.actions.Action;
import com.dasiubat.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Adam on 2014-05-06.
 */

@Service
@Transactional
public class ActionService {
    @Autowired
    private ActionRepository actionRepository;

    public void archive() {
        // get tracked fields
        // get original entity from db using new session
        // compare
    }

    public Action findOne(Long id) {
        return actionRepository.findOne(id);
    }
}
