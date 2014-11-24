package com.icupad.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Stay extends BaseEntity {
    private Integer hl7Id;
    private Timestamp admissionDate;
    private String cause;
    @OneToOne
    private Patient patient;
}
