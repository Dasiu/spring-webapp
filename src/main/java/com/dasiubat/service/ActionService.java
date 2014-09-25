package com.dasiubat.service;

import com.dasiubat.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
        throw new UnsupportedOperationException();
    }

    public Action findOne(Long id) {
        return actionRepository.findOne(id);
    }
}
