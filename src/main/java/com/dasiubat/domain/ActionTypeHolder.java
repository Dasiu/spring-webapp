package com.dasiubat.domain;

import com.dasiubat.domain.enums.Action;
import org.springframework.stereotype.Component;

//@Component
public class ActionTypeHolder {
    private Action action;

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}