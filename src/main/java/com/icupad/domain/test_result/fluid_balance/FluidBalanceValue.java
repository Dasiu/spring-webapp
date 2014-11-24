package com.icupad.domain.test_result.fluid_balance;

import com.icupad.domain.BaseEntity;
import com.icupad.domain.Comment;
import com.icupad.domain.Stay;
import com.icupad.domain.test_result.TestResult;
import com.icupad.domain.user.User;

import javax.persistence.*;

@Entity
public class FluidBalanceValue extends TestResult {
    @ManyToOne
    private FluidBalancePosition position;
}
