package com.dasiubat.domain.actions;

/**
 * Created by adam-bat-usr on 26/09/2014.
 */
public class AttributeHistoryEntry {
    private String oldValue;
    private String newValue;
    private String name;
    private Action action;

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }
}
