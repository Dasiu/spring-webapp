package com.dasiubat.domain.actions;

import com.dasiubat.domain.BaseModel;
import com.dasiubat.domain.enums.ActionType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
public abstract class ActionRelatedToCase<T extends BaseModel> extends Action<T> {
}
