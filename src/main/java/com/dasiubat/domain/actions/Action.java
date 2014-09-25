package com.dasiubat.domain.actions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public abstract class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date creationDate;

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
