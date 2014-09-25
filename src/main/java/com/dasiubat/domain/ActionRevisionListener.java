package com.dasiubat.domain;

import com.dasiubat.domain.enums.Action;
import com.dasiubat.utils.ContextLookup;
import org.hibernate.envers.RevisionListener;

/**
 * Created by adam-bat-usr on 24/09/2014.
 */
public class ActionRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revision) {
        ActionTypeHolder actionTypeHolder = ContextLookup.getBean(ActionTypeHolder.class);
        setAction((ActionRevision) revision, actionTypeHolder);
        eraseActionType(actionTypeHolder);
    }

    private void eraseActionType(ActionTypeHolder actionTypeHolder) {
        actionTypeHolder.setAction(null);
    }

    private void setAction(ActionRevision actionRevision, ActionTypeHolder actionTypeHolder) {
        actionRevision.setAction(actionTypeHolder.getAction());
    }
}
