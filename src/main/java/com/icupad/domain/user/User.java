package com.icupad.domain.user;

import com.icupad.domain.BaseEntity;

import javax.persistence.Entity;

@Entity
public abstract class User extends BaseEntity {
    private Integer hl7Id;
}
