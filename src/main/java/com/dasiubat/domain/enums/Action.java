package com.dasiubat.domain.enums;

public enum Action {
    CASE(true),
    CALENDAR(true),
    MESSAGE(false);

    private final boolean isConnectedWithCase;

    private Action(boolean isConnectedWithCase) {
        this.isConnectedWithCase = isConnectedWithCase;
    }

    public boolean isConnectedWithCase() {
        return isConnectedWithCase;
    }
}
