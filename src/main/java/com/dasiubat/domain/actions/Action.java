package com.dasiubat.domain.actions;

import com.dasiubat.domain.BaseModel;
import com.dasiubat.domain.enums.ActionType;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToOne;
import java.util.*;

@Entity
public abstract class Action<T extends BaseModel> extends BaseModel {
    private ActionType type;
    private Date creationDate;

    @OneToOne
    private BaseModel model;

    public abstract boolean isRelatedToCase();
    public abstract String propertyToString(T model, String property);

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    public T getModel() {
        return (T) model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
