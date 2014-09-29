package com.dasiubat.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by adam-bat-usr on 29/09/2014.
 */
@Embeddable
public class ModelReference {
    @Column(name = "id_model")
    private int modelId;

    @Column(name = "model_type")
    private String modelType;

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }
}
