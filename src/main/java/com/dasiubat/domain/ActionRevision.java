package com.dasiubat.domain;

import com.dasiubat.domain.enums.Action;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.*;

/**
 * Created by adam-bat-usr on 24/09/2014.
 */
@Entity
@RevisionEntity(ActionRevisionListener.class)
@Table(name = "action_revision")
public class ActionRevision extends DefaultRevisionEntity {
    @Enumerated(EnumType.STRING)
    private Action action;


    public void setAction(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }
}
