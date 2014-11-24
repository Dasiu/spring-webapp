package com.icupad.domain.test_result.fluid_balance;

import com.icupad.domain.BaseEntity;

import javax.persistence.Entity;

@Entity
// FIXME come up with better name
public abstract class FluidBalancePosition extends BaseEntity {
    private String name;
    private FluidBalanceGroup group;
}
