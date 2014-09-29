package com.dasiubat.domain.actions;

import com.dasiubat.domain.BaseModel;
import com.dasiubat.domain.ModelReference;
import com.dasiubat.domain.enums.ActionType;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public abstract class Action<T extends BaseModel> extends BaseModel {
    private ActionType type;

    @NotNull
    private Date creationDate;

    // TODO logged user

    private ModelReference modelReference;

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

    public ModelReference getModelReference() {
        return modelReference;
    }

    public void setModelReference(ModelReference modelReference) {
        this.modelReference = modelReference;
    }

    public abstract @NotNull Collection<String> getExcludedProperties();
}
