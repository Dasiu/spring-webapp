package com.webapp.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public abstract class AuditableEntity extends BaseEntity {
    @CreatedBy
    @ManyToOne
    protected User createdBy;

    @CreatedDate
    protected LocalDateTime createdDate;

    @LastModifiedBy
    @ManyToOne
    protected User lastModifiedBy;

    @LastModifiedDate
    protected Date lastModifiedDate;
}
