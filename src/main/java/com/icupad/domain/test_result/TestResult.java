package com.icupad.domain.test_result;

import com.icupad.domain.AuditableEntity;
import com.icupad.domain.Comment;
import com.icupad.domain.Stay;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class TestResult extends AuditableEntity {
    @OneToOne
    private Comment comment;
    @OneToOne
    private Stay stay;
}
