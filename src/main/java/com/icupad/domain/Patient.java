package com.icupad.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Patient extends BaseEntity {
    private Integer hl7Id;
    @OneToMany
    private Collection<Stay> stays;
}
